package com.tech387.wokroutapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "exercise_table")
public class Exercise {

    @ColumnInfo(name = "_id")
    @PrimaryKey
    private final long mId;

    @ColumnInfo(name = "raw_name")
    private final String mRawName;

    @ColumnInfo(name = "title")
    private final String mTitle;

    @ColumnInfo(name = "image")
    private final String mImage;

    @ColumnInfo(name = "video")
    private final String mVideo;

    @ColumnInfo(name = "muscles_involved")
    private final String mMuscle;

    @Ignore
    private List<Tag> mTags;

    public Exercise(long id, String rawName, String title, String image, String video, String muscle) {
        mId = id;
        mRawName = rawName;
        mTitle = title;
        mImage = image;
        mVideo = video;
        mMuscle = muscle;
    }

    public long getId() {
        return mId;
    }

    public String getRawName() {
        return mRawName;
    }


    public String getTitle() {
        return mTitle;
    }




    public String getVideo() {
        return mVideo;
    }


    public String getMuscle() {
        return mMuscle;
    }

    public List<Tag> getTags() {
        return mTags;
    }

    public void setTags(List<Tag> tags) {
        mTags = tags;
    }


    public String getImage() {
        return mImage;
    }
}
