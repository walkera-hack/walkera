using QRW100FlightController.Controller;
using QRW100FlightController.Video;
using System;
using System.Threading;
using System.Windows.Forms;

namespace QRW100FlightController
{
    class Program
    {
        // private members
        static private QuadController _controller;
        static ManualResetEvent _quitEvent = new ManualResetEvent(false);

        static void Main(string[] args)
        {
            Console.CancelKeyPress += (sender, eArgs) =>
            {
                _quitEvent.Set();
                eArgs.Cancel = true;
            };

            _controller = new QuadController();
            
            // instantiate video stream
            Application.Run(new VideoStream(Properties.Settings.Default.StreamURL));

            _quitEvent.WaitOne();
        }
    }
}
