package com.tech387.wokroutapp.main;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainBinding {

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
