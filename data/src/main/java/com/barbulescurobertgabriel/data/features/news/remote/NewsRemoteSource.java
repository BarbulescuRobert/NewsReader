package com.barbulescurobertgabriel.data.features.news.remote;

import com.barbulescurobertgabriel.data.features.news.model.Article;
import com.barbulescurobertgabriel.data.features.news.remote.mapper.NewsDtoToNewsMapper;
import com.barbulescurobertgabriel.data.remote.NewsApi;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mihai.mecea on 03.May.2020
 */
public class NewsRemoteSource {

    //Don't copy this api key, use your own by registering here https://newsapi.org/register
    private static final String API_KEY = "3b9e4aee5f9644de842a13481c508023";
    private static final String EN_LANGUAGE_FILTER = "en";
    @NonNull
    private final NewsApi newsApi;

    public NewsRemoteSource(@NonNull NewsApi newsApi) {
        this.newsApi = newsApi;
    }

    public Single<List<Article>> getNewsArticles() {
        return newsApi.getNewsArticles(API_KEY, EN_LANGUAGE_FILTER)
                      .subscribeOn(Schedulers.io())
                      .map(new NewsDtoToNewsMapper());
    }

}
