package com.tech387.wokroutapp.main.wokrouts;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import com.tech387.wokroutapp.data.Tag;

import java.util.List;

public class WorkoutBinding {

    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:workoutTags"})
    public static void setText(TextView textView, List<Tag> tags) {
        //img
        String finalTags = "";
        for (int i = 0; i < tags.size(); i++) {
            finalTags += tags.get(i).getName();

        }

        textView.setText(finalTags);
    }
}
