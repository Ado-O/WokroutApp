package com.tech387.wokroutapp.main.wokrouts;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.TextView;

import com.tech387.wokroutapp.data.Tag;
import com.tech387.wokroutapp.data.storage.remote.response.WorkoutTagResponse;

import java.util.ArrayList;
import java.util.List;

public class WorkoutBinding {

    private static final String TAG = WorkoutBinding.class.getSimpleName();


    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:workoutTags"})
    public static void setText(TextView textView, List<Tag> tags) {
        //img
        String finalTags = "";

        for (int i = 0; i < tags.size(); i++) {

                finalTags += tags.get(i).getName();

                if (i < tags.size() - 1) {
                    finalTags += ", ";
                }
        }

        textView.setText(finalTags);
    }

}
