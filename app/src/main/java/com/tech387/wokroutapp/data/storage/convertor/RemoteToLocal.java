package com.tech387.wokroutapp.data.storage.convertor;

import android.util.Log;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.ExerciseTag;
import com.tech387.wokroutapp.data.Tag;
import com.tech387.wokroutapp.data.Workout;
import com.tech387.wokroutapp.data.storage.remote.response.ExerciseResponse;
import com.tech387.wokroutapp.data.storage.remote.response.TagResponse;
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

    /**
     * we redict response from networking (tags)
     *
     * @param tagResponses -> object wich we get tags
     * @return
     */
    public static List<Tag> tagConvertor(List<TagResponse> tagResponses) {
        List<Tag> tags = new ArrayList<>();

        for (TagResponse t : tagResponses) {
            tags.add(
                    new Tag(
                            t.getmId(),
                            t.getmName()
                    )
            );
        }
        return tags;
    }

    /**
     * attempt to create exerciseTagConverter
     *
     * @param exerciseResponses
     * @return
     */
    public static List<ExerciseTag> exerciseTagConverter(
            List<ExerciseResponse> exerciseResponses
    ) {

        List<ExerciseTag> exerciseTag = new ArrayList<>();

        for (ExerciseResponse e : exerciseResponses) {
            Log.e(TAG, String.valueOf(e.getTags()));
            exerciseTag.add(
                    new ExerciseTag(
                            e.getId(),
                            e.getTags()
                    )
            );

        }
        return exerciseTag;
    }

}