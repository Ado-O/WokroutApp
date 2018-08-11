package com.tech387.wokroutapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.tech387.wokroutapp.Injection;
import com.tech387.wokroutapp.R;
import com.tech387.wokroutapp.data.Format;
import com.tech387.wokroutapp.data.storage.ContentRepository;
import com.tech387.wokroutapp.data.storage.FormatRespository;
import com.tech387.wokroutapp.data.storage.remote.content.ContentRemoteDataSource;
import com.tech387.wokroutapp.data.storage.remote.response.BaseResponse;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = Main2Activity.class.getSimpleName();

    private Toolbar mToolbar;
    private int course;
    private ContentRepository mContentRepository;
    private FormatRespository mFormatRespository;
    private ContentRemoteDataSource contentRemoteDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv2);

        //find view
        mToolbar = findViewById(R.id.second_tb);


        course = getIntent().getExtras().getInt("course");
        Log.e(TAG, String.valueOf(course));

        setupToolbar();
        setupImgData();
    }

    /**
     * toolbar
     */
    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("something");

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
    public void setupImgData() {

        contentRemoteDataSource.getContent(new ContentRemoteDataSource.GetContentCallback() {
            @Override
            public void onSuccess(BaseResponse content) {
           String url =  content.getResponseResponse().getExercise().get(0).getFormats().get(0).getSource();
                Log.e(TAG,url);

            }

            @Override
            public void onError() {

            }
        });

        // Glide.with(Main2Activity.this)
        //          .load(videos.get(0).getImg())
        //         .into(mImageView);

        /**
        mContentRepository = Injection.provideContentRepository(Main2Activity.this);
        mContentRepository.getContent();

        mFormatRespository = Injection.provideFormatRepository(Main2Activity.this);
        mFormatRespository.getFormat(new FormatRespository.GetFormatCallback() {
            @Override
            public void onSuccess(List<Format> format) {
                Log.e(TAG, format.get(0).getSource());
            }

            @Override
            public void onError() {

            }
        });
*/
    }
}
