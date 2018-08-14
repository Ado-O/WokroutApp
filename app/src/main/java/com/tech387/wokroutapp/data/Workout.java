package com.tech387.wokroutapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "workout_table")
public class Workout {

    @ColumnInfo(name = "_id")
    @PrimaryKey
    private long mId;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "description")
    private String mDescription;

    @Ignore
    private List<Tag> mTags;

    public Workout(long id, String name, String description) {
        mId = id;
        mName = name;
        mDescription = description;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public List<Tag> getTags() { return mTags; }

    public void setTags(List<Tag> tags) {
        mTags = tags;
    }
}