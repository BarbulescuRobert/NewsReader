package com.barbulescurobertgabriel.newsreader.bindings;

import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageBinding {

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView, @Nullable String url) {
        Glide
                .with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

}
