package com.tech387.wokroutapp.data.storage;

import android.util.Log;

import com.tech387.wokroutapp.data.Workout;
import com.tech387.wokroutapp.data.storage.local.workout.WorkoutLocalDataSource;

import java.util.List;

public class WorkoutRepository {

    public static final String TAG = WorkoutRepository.class.getSimpleName();

    private static WorkoutRepository sInstance = null;

    private final WorkoutLocalDataSource mWoekoutLocalDataSource;

    //construct
    private WorkoutRepository(WorkoutLocalDataSource workoutLocalDataSource) {
        mWoekoutLocalDataSource = workoutLocalDataSource;
    }

    public static WorkoutRepository getInstance(WorkoutLocalDataSource workoutLocalDataSource) {
        if (sInstance == null) {
            sInstance = new WorkoutRepository(workoutLocalDataSource);
        }
        return sInstance;
    }

    public void getWorkout(final GetWorkoutsCallback callback) {
        mWoekoutLocalDataSource.getWorkouts(new WorkoutLocalDataSource.GetWorkoutsCallback() {
            @Override
            public void onSuccess(List<Workout> workouts) {
                callback.onSuccess(workouts);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public interface GetWorkoutsCallback {
        void onSuccess(List<Workout> workouts);

        void onError();
    }

}
