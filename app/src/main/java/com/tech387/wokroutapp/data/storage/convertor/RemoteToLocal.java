package com.tech387.wokroutapp.data.storage.convertor;


import android.util.Log;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.ExerciseTag;
import com.tech387.wokroutapp.data.Tag;
import com.tech387.wokroutapp.data.Workout;
import com.tech387.wokroutapp.data.WorkoutTag;
import com.tech387.wokroutapp.data.storage.remote.response.ExerciseResponse;
import com.tech387.wokroutapp.data.storage.remote.response.FormatResponse;
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
     * @return -> new create list, which have all needed data
     */
    public static List<Exercise> exerciseConverter(List<ExerciseResponse> exerciseResponses) {

        List<Exercise> exercises = new ArrayList<>();

        for (ExerciseResponse e : exerciseResponses) {

            String videoUrl = "";

            for (FormatResponse f : e.getFormats()) {
                if (f.getType().equals("mp4")) {
                    videoUrl = f.getSource();
                    break;
                }
            }


            exercises.add(
                    new Exercise(
                            e.getId(),
                            e.getRawName(),
                            e.getName(),
                            e.getThumbnail(),
                            videoUrl,
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
     * @return -> new create list, which have all needed data
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

    /**
     * we redict response from networking (tags)
     *
     * @param tagResponses -> object wich we get Tags
     * @return -> new create list, which have all needed data
     */
    public static List<Tag> tagConverter(List<TagResponse> tagResponses) {
        List<Tag> tags = new ArrayList<>();

        for (TagResponse t : tagResponses) {
            tags.add(
                    new Tag(
                            t.getId(),
                            t.getName(),
                            t.getWorkoutType()
                    )
            );
        }
        return tags;
    }

    /**
     * in this case we create table exercise_tag_table and send from exercise_table id and tag
     *
     * @param exerciseId -> get id from exercise
     * @param tags       ->get all tags from exercise
     * @return -> new create list, which have all needed data
     */
    public static List<ExerciseTag> exerciseTagConverter(long exerciseId, List<Integer> tags) {
        List<ExerciseTag> exerciseTags = new ArrayList<>();

        for (long tagId : tags) {
            exerciseTags.add(new ExerciseTag(exerciseId, tagId));
        }

        return exerciseTags;
    }


    /**
     * @param workoutId -> get id from workout
     * @param tags      -> get all tags from workout
     * @return
     */
    public static List<WorkoutTag> workoutTagsConverter(long workoutId, List<Integer> tags) {
        List<WorkoutTag> workoutTags = new ArrayList<>();

       // Log.e(TAG, String.valueOf(tags));
        for (long tagId : tags) {
            workoutTags.add(new WorkoutTag(workoutId, tagId));
        }

        return workoutTags;
    }

}