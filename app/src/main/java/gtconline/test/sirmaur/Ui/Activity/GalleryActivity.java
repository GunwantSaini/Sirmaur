package gtconline.test.sirmaur.Ui.Activity;

import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import gtconline.test.sirmaur.R;


public class GalleryActivity extends AppCompatActivity {

    TextView showInfo;

    private static ProgressDialog progressDialog;
    String videourl="https://firebasestorage.googleapis.com/v0/b/sirmaur2.appspot.com/o/VidTrim_1967.mp4?alt=media&token=0ec415db-8e06-404f-ac06-dd995d5abf1b";
    VideoView videoView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);



            videoView = (VideoView) findViewById(R.id.videoView);

         //   progressDialog = ProgressDialog.show(GalleryActivity.this, "", "Buffering video...",true);
        //    progressDialog.setCancelable(true);


            playVideo();



    }


    public void playVideo()
    {
            try
            {
                getWindow().setFormat(PixelFormat.TRANSLUCENT);
                MediaController mediaController = new MediaController(GalleryActivity.this);
                mediaController.setAnchorView(videoView);

                mediaController.setMediaPlayer(videoView);

                Uri video = Uri.parse(videourl);
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(video);
                videoView.requestFocus();
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
                {
                    public void onPrepared(MediaPlayer mp)
                    {
               //         progressDialog.dismiss();
                        videoView.start();
                    }
                });

            }
            catch(Exception e)
            {
                progressDialog.dismiss();
                finish();
            }
        }


}
