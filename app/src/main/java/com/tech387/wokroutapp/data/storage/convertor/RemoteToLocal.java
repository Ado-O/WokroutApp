package com.tech387.wokroutapp.data.storage.convertor;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.ExerciseTag;
import com.tech387.wokroutapp.data.Workout;
import com.tech387.wokroutapp.data.storage.remote.response.ExerciseResponse;
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
                            e.getThumbnail(),
                            e.getFormats().get(1).getSource(),
                            e.getMusclesInvolved()
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
    public static List<Workout> workoutConverter(List<WorkoutResponse> workoutResponses) {
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

    public static List<ExerciseTag> exerciseTagConverter(long exerciseId, List<Long> tags) {
        List<ExerciseTag> exerciseTags = new ArrayList<>();

        for (long tagId : tags) {
            exerciseTags.add(new ExerciseTag(exerciseId, tagId));
        }

        return exerciseTags;
    }

}