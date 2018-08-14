package com.tech387.wokroutapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "workout_tag_table")
public class WorkoutTag {

    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    private Integer mId;

    @ColumnInfo(name = "workout_id")
    private long mWorkoutId;

    @ColumnInfo(name = "tag_id")
    private long mTagId;

    public WorkoutTag(Integer id, long workoutId, long tagId) {
        mId = id;
        mWorkoutId = workoutId;
        mTagId = tagId;
    }

    @Ignore
    public WorkoutTag(long workoutId, long tagId) {
        mId = null;
        mWorkoutId = workoutId;
        mTagId = tagId;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer mId) {
        this.mId = mId;
    }

    public long getWorkoutId() {
        return mWorkoutId;
    }

    public void setWorkoutId(long mWorkoutId) {
        this.mWorkoutId = mWorkoutId;
    }

    public long getTagId() {
        return mTagId;
    }

    public void setTagId(long mTagId) {
        this.mTagId = mTagId;
    }
}
