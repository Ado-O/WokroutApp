package com.tech387.wokroutapp.data.storage.convertor;

import android.util.Log;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.Format;
import com.tech387.wokroutapp.data.Workout;
import com.tech387.wokroutapp.data.storage.remote.response.ExerciseResponse;
import com.tech387.wokroutapp.data.storage.remote.response.FormatResponse;
import com.tech387.wokroutapp.data.storage.remote.response.WorkoutResponse;

import java.util.ArrayList;
import java.util.List;

public class RemoteToLocal {

    private static final String TAG = RemoteToLocal.class.getSimpleName();

    /**
     * we redict response from networking (exercise)
     *
     * @param exerciseResponses -> object wich we get exercise
     * @return
     */
    public static List<Exercise> exerciseConverter(List<ExerciseResponse> exerciseResponses) {

        List<Exercise> exercises = new ArrayList<>();

        for (ExerciseResponse e : exerciseResponses) {
            exercises.add(
                    new Exercise(
                            e.getId(),
                            e.getRawName(),
                            e.getName(),
                            e.getThumbnail()
                    )
            );
        }
        return exercises;
    }

    /**
     * we redict response from networking (workout)
     *
     * @param workoutResponses -> object wich we get workout
     * @return
     */
    public static List<Workout> workoutConvertor(List<WorkoutResponse> workoutResponses) {
        List<Workout> workouts = new ArrayList<>();

        for (WorkoutResponse w : workoutResponses) {
            workouts.add(
                    new Workout(w.getId(),
                            w.getName(),
                            w.getDescription()
                    )
            );
        }

        return workouts;
    }

    public static List<Format> formatConvertor(List<FormatResponse> formatResponses) {
        List<Format> formats = new ArrayList<>();

        for (FormatResponse t : formatResponses) {
            Log.e(TAG, t.getSource());

            formats.add(
                    new Format(t.getId(),
                            t.getSource()
                    )
            );
        }

        return formats;
    }
}