using AirCraftObjectTracking.Controller.Services;
using AirCraftObjectTracking.Recognition;
using System;
using SharpDX.DirectInput;

namespace AirCraftObjectTracking.Controller
{
    class QuadController
    {
        // local vars
        private PositionServices _positionServices;
        private ProtocolServices _protocolServices;
        private DirectInput _directInput;
        private Joystick _HIDTransmitterInterface;
        private MessageModel _HIDControlsModel;
        private IDisposable _timerID;

        private const int CONTROL_RATES = 1;

        #region EventHandler definition
        // Define event used for updating notification messages on UI
        public delegate void UpdateNotificationMessageEventHandler(object sender, string message);
        public event UpdateNotificationMessageEventHandler UpdateNotificationMessage;
        #endregion

        #region Cunstructor/Destructor
        /*
         * Default constructor
         */
        public QuadController(ObjectRecognition objectRecognition)
        {
            // instantiate services
            _positionServices = new PositionServices(objectRecognition);
            _protocolServices = new ProtocolServices(_positionServices);

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
         * Start sending init connect sequence via protocol
         */
        public void Connect()
        {
            _positionServices.Connect();
            _protocolServices.Connect();
            _protocolServices.StartAsync();
        }

        /*
         * Stop sending any cmd sequence via protocol
         */
        public void Disconnect()
        {

            _positionServices.Disconnect();
            _protocolServices.StopAsync();
            _protocolServices.Disconnect();
        }

        /*
         * Start sending control cmd sequances
         */
        public void StartTracking()
        {
            Console.WriteLine("StartTracking");
            _positionServices.StartPositionCalculation();
            UpdateNotificationMessage(this, Properties.Settings.Default.NotificationTextStop);
        }

        /*
         * Stop sending control cmd sequances
         */
        public void StopTracking()
        {
            Console.WriteLine("StopTracking");
            _positionServices.StopPositionCalculation();
            UpdateNotificationMessage(this, String.Concat(Properties.Settings.Default.NotificationTextStart, " || ", Properties.Settings.Default.NotificationTextLand));
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

            _HIDControlsModel = new MessageModel();

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
                                _HIDControlsModel.Aileron = state.Value / CONTROL_RATES;
                                break;
                            }
                        case JoystickOffset.Y:
                            {
                                _HIDControlsModel.Elevator = state.Value / CONTROL_RATES;
                                break;
                            }
                        case JoystickOffset.RotationZ:
                            {
                                _HIDControlsModel.Rudder = state.Value / CONTROL_RATES;
                                break;
                            }
                        case JoystickOffset.Sliders0:
                            {
                                _HIDControlsModel.Throttle = state.Value / CONTROL_RATES;
                                break;
                            }
                        case JoystickOffset.Buttons0:
                            {
                                // START/STOP Tracking
                                if(state.Value == 0 && !_positionServices.TrackingInProgress)
                                {
                                    StartTracking();
                                }
                                // don't call stop everytime, just in case that we have active tracking
                                else if(_positionServices.TrackingInProgress)
                                {
                                    StopTracking();
                                }
                                break;
                            }
                    }
                }

                // manual controlling only if tracking isn't in progress
                if(!_positionServices.TrackingInProgress)
                {
                    _positionServices.OnHIDControl(_HIDControlsModel);
                }
            }

        }
        #endregion
    }
}
