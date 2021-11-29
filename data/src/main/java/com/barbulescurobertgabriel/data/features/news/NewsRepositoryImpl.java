package com.barbulescurobertgabriel.data.features.news;

import com.barbulescurobertgabriel.data.NewsRepository;
import com.barbulescurobertgabriel.data.features.news.model.Article;
import com.barbulescurobertgabriel.data.features.news.remote.NewsRemoteSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

/**
 * Created by mihai.mecea on 03.May.2020
 */
public class NewsRepositoryImpl implements NewsRepository {

    private final NewsRemoteSource remoteSource;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource) {
        this.remoteSource = remoteSource;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles();
    }

}
