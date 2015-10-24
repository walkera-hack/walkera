using QRW100FlightController.Properties;
using System;
using System.Net.Sockets;
using System.Text;

namespace QRW100FlightController.Controller.Services
{
    class ProtocolServices
    {
        // local vars
        private UdpClient _udpClient;
        private IDisposable _timerID;
        private byte[] _commandMessage;

        #region Cunstructor/Destructor
        /*
         * Default constructor
         */
        public ProtocolServices()
        {
            // TODO
        }

        /*
         * Destroy function
         */
        public void Destroy()
        {
            StopAsync();
            Disconnect();
        }        
        #endregion

        #region Timer Start/Stop
        /*
         * Start sending async commands on configured interval
         */
        public void StartAsync()
        {
            _timerID = Utils.SetTimer(SendMessage, Properties.Settings.Default.SyncInterval);
        }

        /*
         * Stop sending async commands on configured interval
         */
        public void StopAsync()
        {
            _timerID.Dispose();
        }
        #endregion

        #region UDP Connect/Disconnect
        /*
         * Connect via UDP
         */
        public void Connect()
        {
            _udpClient = new UdpClient(Settings.Default.SourcePort);
            _udpClient.Connect(Settings.Default.HostName, Settings.Default.HostPort);
        }

        /*
         * Disconnect
         */
        public void Disconnect()
        {
            _udpClient.Close();
        }
        #endregion

        #region Message construction and sending
        /*
         * Compose final message to be sent
         * 
         * --
         * AA 55 60 01 7F 7F 7F 7F 01 01 01 5F
         * AA 55 6e tt rr ee aa gg tt 01 01 cc
         * --
         * 
         * Placeholders:
         * e = 1 -> enable wifi control
         * tt = throttle, 01 = min (off), ff = max (comes twice !)
         * rr = rudder, 01 = min, 7f = center, ff = max
         * ee = elevation
         * aa = aileron
         * gg = gyro
         * cc = checksum
         */
        public void OnPositionMessageModelChanged(MessageModel positionMessageModel)
        {
            // use string builder instead of regular string and concatenate method - much better mem management
            StringBuilder constructedMessage = new StringBuilder();

            //compose string message from model

            // AA 55 - package start
            constructedMessage.Append(positionMessageModel.PackageStart.ToString("X4"));
            // 6e - WiFi control
            constructedMessage.Append(positionMessageModel.WiFiControl.ToString("X2"));
            // tt - throttle
            constructedMessage.Append(positionMessageModel.Throttle.ToString("X2"));
            // rr - rudder
            constructedMessage.Append(positionMessageModel.Rudder.ToString("X2"));
            // ee - elevator
            constructedMessage.Append(positionMessageModel.Elevator.ToString("X2"));
            // aa - aileron
            constructedMessage.Append(positionMessageModel.Aileron.ToString("X2"));
            // gg - gyro
            constructedMessage.Append(positionMessageModel.Gyro.ToString("X2"));
            // tt - throttle
            constructedMessage.Append(positionMessageModel.Throttle.ToString("X2"));
            // 01 01 - package end
            constructedMessage.Append(positionMessageModel.PackageEnd.ToString("X4"));
            // cc - checksum
            // calculate checksum and add it at the end of message
            string checksum = Utils.CalculateChecksum(constructedMessage.ToString());
            constructedMessage.Append(checksum);

            // convert string to byte array
            _commandMessage = Utils.HexString2Bytes(constructedMessage.ToString());
        }

        /*
         * Send message via UDP
         */
        private void SendMessage()
        {
            _udpClient.Send(_commandMessage, _commandMessage.Length);
            _udpClient.Send(_commandMessage, _commandMessage.Length);

            Console.WriteLine(Utils.Bytes2HexString(_commandMessage));
        }
        #endregion
    }
}
