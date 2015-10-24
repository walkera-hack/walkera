using System;
using System.Linq;
using System.Runtime.Remoting.Metadata.W3cXsd2001;
using System.Text.RegularExpressions;
using System.Windows.Forms;
using System.Text;

namespace AirCraftObjectTracking.Controller
{
    public static class Utils
    {
        /*
         * Calculate checksum for provided hex string
         */
        public static string CalculateChecksum(string hexString)
        {
            //check for null
            if (hexString == null) return null;

            // remove white spaces if presented
            hexString = Regex.Replace(hexString, @"\s+", "");

            // calculate checksum
            byte[] buf = SoapHexBinary.Parse(hexString).Value;
            int chkSum = buf.Aggregate(0, (s, b) => s += b) & 0xff;

            // convert calculated checksum from decimal to hex string and return it
            return chkSum.ToString("X2");
        }

        /*
         * Convert hex string to byte array
         */
        public static byte[] HexString2Bytes(string hexString)
        {
            //check for null
            if (hexString == null) return null;

            // remove white spaces if presented
            hexString = Regex.Replace(hexString, @"\s+", "");

            //get length
            int len = hexString.Length;
            if (len % 2 == 1) return null;
            int len_half = len / 2;
            //create a byte array
            byte[] bs = new byte[len_half];
            try
            {
                //convert the hexstring to bytes
                for (int i = 0; i != len_half; i++)
                {
                    bs[i] = Convert.ToByte(hexString.Substring(i * 2, 2), 16);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Exception : " + ex.Message);
            }

            //return the byte array
            return bs;
        }

        /*
         * Convert byte array to hex string
         */
        public static string Bytes2HexString(byte[] bytes)
        {
            //check for null
            if (bytes == null) return null;

            StringBuilder sb = new StringBuilder();
            foreach (byte b in bytes)
            {
                sb.AppendFormat(" {0:X2}", b);
            }

            //return string
            return sb.ToString();
        }

        /*
         * Set timeout and return disposable ref
         */
        public static IDisposable SetTimeout(Action method, int delayInMilliseconds)
        {
            System.Timers.Timer timer = new System.Timers.Timer(delayInMilliseconds);
            timer.Elapsed += (source, e) =>
            {
                method();
            };

            timer.AutoReset = false;
            timer.Enabled = true;
            timer.Start();

            // Returns a stop handle which can be used for stopping
            // the timer, if required
            return timer as IDisposable;
        }

        /*
         * Set timer and return disposable ref
         */
        public static IDisposable SetTimer(Action method, int delayInMilliseconds)
        {
            System.Windows.Forms.Timer timer = new System.Windows.Forms.Timer();
            timer.Interval = delayInMilliseconds;
            timer.Tick += (source, e) =>
            {
                method();
            };

            timer.Enabled = true;
            timer.Start();

            // Returns a stop handle which can be used for stopping
            // the timer, if required
            return timer as IDisposable;
        }
    }
}
