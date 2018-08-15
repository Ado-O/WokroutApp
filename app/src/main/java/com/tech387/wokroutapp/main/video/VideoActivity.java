package com.tech387.wokroutapp.main.video;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.tech387.wokroutapp.R;
import com.tech387.wokroutapp.data.Video;
import com.tech387.wokroutapp.databinding.VideoAtvBinding;

public class VideoActivity extends AppCompatActivity {

    private static final String TAG = VideoActivity.class.getSimpleName();

    public String course;
    public String courseTitle;
    public String courseVideo;
    private VideoAtvBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_atv);

        courseVideo = getIntent().getExtras().getString("courseVideo");
        course = getIntent().getExtras().getString("course");

        binding = DataBindingUtil.setContentView(this, R.layout.video_atv);
        Video video = new Video(courseVideo, course);

        binding.setVideo(video);

        //add setup
        setupToolbar();
    }

    /**
     * toolbar
     */
    private void setupToolbar() {
        courseTitle = getIntent().getExtras().getString("courseTitle");

        setSupportActionBar(binding.secondTb);
        getSupportActionBar().setTitle(courseTitle);

        //setting up the back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.secondTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }

}