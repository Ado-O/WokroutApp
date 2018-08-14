package com.tech387.wokroutapp.main.exercises;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tech387.wokroutapp.data.Tag;

import java.util.List;

public class ExerciseBinding {

    private static final String TAG = ExerciseBinding.class.getSimpleName();

    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:exerciseTags"})
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

    //image
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:loadImage"})
    public static void setImage(ImageView view, String img){
        //img
        Glide.with(view.getContext())
                .load(img)
                .into(view);
    }

}

