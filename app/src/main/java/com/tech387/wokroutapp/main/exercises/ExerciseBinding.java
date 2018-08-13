package com.tech387.wokroutapp.main.exercises;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tech387.wokroutapp.data.Tag;

import java.util.List;

public class ExerciseBinding {

    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:exerciseTags"})
    public static void setImage(TextView textView, List<Tag> tags) {
        //img
        String finalTags = "";

        for (int i = 0; i < tags.size(); i++) {
            finalTags += tags.get(i).getName();

            if (i < tags.size() - 1) {
                finalTags += ",";
            }

        }

        textView.setText(finalTags);
    }


}

