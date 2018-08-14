package com.tech387.wokroutapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tag_table")
public class Tag {

    @ColumnInfo(name = "_id")
    @PrimaryKey
    private long mId;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "workout_type")
    private String mWorkoutType;

    public Tag(long id, String name, String workoutType) {
        mId = id;
        mName = name;
        mWorkoutType = workoutType;
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

    public String getWorkoutType() {
        return mWorkoutType;
    }

    public void setWorkoutType(String mWorkoutType) {
        this.mWorkoutType = mWorkoutType;
    }
}
