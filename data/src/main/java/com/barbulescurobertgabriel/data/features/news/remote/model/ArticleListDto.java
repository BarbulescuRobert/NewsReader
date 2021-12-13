package com.barbulescurobertgabriel.data.features.news.remote.model;

import java.util.List;

/**
 * Created by mihai.mecea on 03.May.2020
 */
public class ArticleListDto {
    public final int totalResults;
    public final List<ArticleDto> articles;

    ArticleListDto(int totalResults, List<ArticleDto> articles) {
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
