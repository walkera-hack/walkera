using System;
using SharpDX.DirectInput;
using QRW100FlightController.Properties;
using QRW100FlightController.Controller.Services;

namespace QRW100FlightController.Controller
{
    public partial class QuadController

    {
        // local vars
        private ProtocolServices _protocolServices;
        private DirectInput _directInput;
        private Joystick _HIDTransmitterInterface;
        private IDisposable _timerID;
        private MessageModel _positions = null;

        // local consts
        private const int PACKAGE_START_BITS = 43605;   // hex AA55
        private const int PACKAGE_END_BITS = 257;       // hex 0101
        private const int PACKAGE_WIFI_CONTROL_ON = 97;    // hex 61
        private const int PACKAGE_WIFI_CONTROL_OFF = 96;   // hex 60

        private const int CONTROL_RATES = 1;

        #region Cunstructor/Destructor
        /*
         * Default constructor
         */
        public QuadController()
        {
            // create positions model and set default values
            _positions = new MessageModel();
            ResetPositions();

            // instantiate services
            _protocolServices = new ProtocolServices();

            // init HID Transmitter device
            InitHIDTransmitter();

            Connect();
        }

        /*
         * Destroy function
         */
        public void Destroy()
        {
            Disconnect();
            if(_timerID != null)
            {
                _timerID.Dispose();
            }
        }
        #endregion

        /*
         * Reset positions to default values
         */
        private void ResetPositions()
        {
            Console.WriteLine("ResetPositions invoked.");

            _positions.PackageStart = PACKAGE_START_BITS;
            _positions.WiFiControl = PACKAGE_WIFI_CONTROL_ON;

            _positions.Throttle = Settings.Default.CtrlThrottleMin;
            _positions.Rudder = Settings.Default.CtrlDeviationCenter;
            _positions.Elevator = Settings.Default.CtrlDeviationCenter;
            _positions.Aileron = Settings.Default.CtrlDeviationCenter;
            _positions.Gyro = Settings.Default.CtrlGyro;

            _positions.PackageEnd = PACKAGE_END_BITS;
        }

        /*
         * Start sending init connect sequence via protocol
         */
        public void Connect()
        {
            _protocolServices.Connect();
            _protocolServices.StartAsync();
        }

        /*
         * Stop sending any cmd sequence via protocol
         */
        public void Disconnect()
        {
            _protocolServices.StopAsync();
            _protocolServices.Disconnect();
        }

        #region USB HID Transmitter section
        /*
         * Init USB HID Transmitter and make connection
         */
        private void InitHIDTransmitter()
        {
            // Initialize DirectInput
            _directInput = new DirectInput();

            // Find Transmitter Guid
            var transmitterGuid = Guid.Empty;

            // Find Transmitter
            if (transmitterGuid == Guid.Empty)
                foreach (var deviceInstance in _directInput.GetDevices(DeviceType.Joystick, DeviceEnumerationFlags.AllDevices))
                    transmitterGuid = deviceInstance.InstanceGuid;

            // If no device found, throw an error
            if (transmitterGuid == Guid.Empty)
            {
                Console.WriteLine("No HID device found.");
                Console.ReadKey();
                Environment.Exit(1);
            }

            // Instantiate the joystick
            _HIDTransmitterInterface = new Joystick(_directInput, transmitterGuid);

            Console.WriteLine("Found HID Transmitter (as joystick) with GUID: {0}", transmitterGuid);

            // Set BufferSize in order to use buffered data.
            _HIDTransmitterInterface.Properties.BufferSize = 128;
            _HIDTransmitterInterface.Properties.Range = new InputRange(0, 255);

            // Acquire device
            _HIDTransmitterInterface.Acquire();

            // create timeout for reseting positions if no detection in defined interval
            _timerID = Utils.SetTimer(HIDReadData, 1);
        }

        /*
         * Start reading
         */
        private void HIDReadData()
        {
            // Poll events
            _HIDTransmitterInterface.Poll();
            var bufferedData = _HIDTransmitterInterface.GetBufferedData();
            if (bufferedData != null)
            {
                foreach (var state in bufferedData)
                {
                    switch (state.Offset)
                    {
                        case JoystickOffset.X:
                            {
                                _positions.Aileron = state.Value / CONTROL_RATES;
                                break;
                            }
                        case JoystickOffset.Y:
                            {
                                _positions.Elevator = state.Value / CONTROL_RATES;
                                break;
                            }
                        case JoystickOffset.RotationZ:
                            {
                                _positions.Rudder = state.Value / CONTROL_RATES;
                                break;
                            }
                        case JoystickOffset.Sliders0:
                            {
                                _positions.Throttle = state.Value / CONTROL_RATES;
                                break;
                            }
                        default:
                            {
                                Console.WriteLine("HID:: Unsupported control!");
                                break;
                            }
                    }
                }

                _protocolServices.OnPositionMessageModelChanged(_positions);
            }

        }
        #endregion
    }
}
