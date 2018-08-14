package com.tech387.wokroutapp.main;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.tech387.wokroutapp.R;

public class VideoActivity extends AppCompatActivity {

    private static final String TAG = VideoActivity.class.getSimpleName();

    private Toolbar mToolbar;
    public String course;
    public String courseTitle;
    public String courseVideo;
    private ImageView mImageView;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_atv);

        //find view

        videoView = (VideoView)findViewById(R.id.main_vv_second);
        mToolbar = findViewById(R.id.second_tb);
        mImageView = (ImageView) findViewById(R.id.main_iv_second);

        /**
         * get vidio from raw file
         */
        //forse to repet video
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);

            }
        });

        //add setup
        setupToolbar();
        setupImgData();
        setupVideo();
    }

    /**
     * toolbar
     */
    private void setupToolbar() {
        courseTitle = getIntent().getExtras().getString("courseTitle");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(courseTitle);

        //setting up the back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }

    /**
     * get img from reposotory.class
     */
    private void setupImgData() {

        course = getIntent().getExtras().getString("course");


        Glide.with(VideoActivity.this)
                .load(course)
                .into(mImageView);
    }

    private void setupVideo(){

        courseVideo = getIntent().getExtras().getString("courseVideo");

        videoView.setVideoPath(courseVideo);
        videoView.start();

    }
}
