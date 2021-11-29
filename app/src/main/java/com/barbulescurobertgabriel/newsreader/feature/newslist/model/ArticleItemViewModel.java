package com.barbulescurobertgabriel.newsreader.feature.newslist.model;

public class ArticleItemViewModel {
    public String title, content,imageUrl;

    public ArticleItemViewModel(String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
