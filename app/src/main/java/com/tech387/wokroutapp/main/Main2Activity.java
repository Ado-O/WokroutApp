package com.tech387.wokroutapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tech387.wokroutapp.R;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = Main2Activity.class.getSimpleName();

    private Toolbar mToolbar;
    public String course;
    public String courseTitle;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv2);

        //find view
        mToolbar = findViewById(R.id.second_tb);
        mImageView = (ImageView) findViewById(R.id.main_iv_second);


        setupToolbar();
        setupImgData();
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


        Glide.with(Main2Activity.this)
                 .load(course)
                .into(mImageView);
    }
}
