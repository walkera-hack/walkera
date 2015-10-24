using AForge.Controls;
using AForge.Video;
using System;
using System.Drawing;
using System.Windows.Forms;

namespace QRW100FlightController.Video
{
    public partial class VideoStream : Form
    {
        // local vars
        private IVideoSource _stream;
        private VideoSourcePlayer _videoPlayer;

        #region Cunstructor/Destructor
        /*
         * Default constructor
         */
        public VideoStream(String url)
        {
            InitializeComponent();

            // instantiate picture box for video showing
            _videoPlayer = new VideoSourcePlayer
            {
                Name = "_videoPlayer",
                Size = new Size(640, 480),
                Location = new Point(0, 0),
                Visible = true
            };

            // add the video player to the form
            this.Controls.Add(this._videoPlayer);

            StartVideo(url);
        }

        /*
         * Destroy function
         */
        public void Destroy()
        {
            // remove event listeners
            StopVideo();
            _stream = null;
        }
        #endregion

        /*
         * Start playing video using selected video device
         */
        private void StartVideo(String url)
        {
            // do this only once in case of multiple connect/disconnect actions
            if (_stream == null)
            {
                _stream = new MJPEGStream(url);            
                _videoPlayer.VideoSource = _stream;
            }

            _stream.Start();
        }

        /*
         * Stop playing video
         */
        private void StopVideo()
        {
            _stream.SignalToStop();
        }

        private void InitializeComponent()
        {
            this.SuspendLayout();
            // 
            // VideoStream
            // 
            this.ClientSize = new System.Drawing.Size(624, 441);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "VideoStream";
            this.ShowIcon = false;
            this.ResumeLayout(false);

        }
    }
}
