package com.tech387.wokroutapp.data.storage.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TagResponse implements Serializable{

    @SerializedName("id")
    @Expose
    private long mId;

    @SerializedName("name")
    @Expose
    private String mName;

    @SerializedName("workout_type")
    @Expose
    private String mWorkoutType;

    public TagResponse(long id, String name, String workoutType) {
        this.mId = id;
        this.mName = name;
        this.mWorkoutType = workoutType;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getWorkoutType() {
        return mWorkoutType;
    }

    public void setWorkoutType(String mWorkoutType) {
        this.mWorkoutType = mWorkoutType;
    }
}
