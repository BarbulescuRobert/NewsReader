package com.barbulescurobertgabriel.newsreader.feature.newslist.model;

public class ArticleItemViewModel {
    public final String title;
    public final String content;
    public final String imageUrl;

    public ArticleItemViewModel(String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
