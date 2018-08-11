package com.tech387.wokroutapp.data.storage.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseResponse implements Serializable {

    @SerializedName("exercises")
    @Expose
    private List<ExerciseResponse> mExercise;

    @SerializedName("workouts")
    @Expose
    private List<WorkoutResponse> mWorkouts;

    @SerializedName("format")
    @Expose
    private List<FormatResponse> mFormat;

    public List<ExerciseResponse> getExercise() {
        return mExercise;
    }

    public void setExercise(List<ExerciseResponse> exercise) {
        mExercise = exercise;
    }

    public List<WorkoutResponse> getWorkouts() {
        return mWorkouts;
    }

    public void setWorkouts(List<WorkoutResponse> workouts) {
        mWorkouts = workouts;
    }

    public List<FormatResponse> getmFormat() {
        return mFormat;
    }

    public void setmFormat(List<FormatResponse> format) {
        mFormat = format;
    }

}
