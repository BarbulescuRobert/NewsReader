package com.barbulescurobertgabriel.data.features.news.model;

import io.reactivex.annotations.NonNull;

/**
 * Created by mihai.mecea on 03.May.2020
 */
public class Article {
    @NonNull
    public final String imageUrl;
    @NonNull
    public final String title;
    @NonNull
    public final String content;


    public Article(@NonNull String imageUrl, @NonNull String title, @NonNull String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }
}
