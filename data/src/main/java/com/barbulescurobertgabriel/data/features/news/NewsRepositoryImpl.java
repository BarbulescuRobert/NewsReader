package com.barbulescurobertgabriel.data.features.news;

import com.barbulescurobertgabriel.data.NewsLocalSource.NewsLocalDataStore;
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
    private final NewsLocalDataStore localDataStore;

    public NewsRepositoryImpl(NewsRemoteSource remoteSource, NewsLocalDataStore localDataStore) {
        this.remoteSource = remoteSource;
        this.localDataStore = localDataStore;
    }

    @Override
    @NonNull
    public Single<List<Article>> getNewsArticles() {
        return remoteSource.getNewsArticles().doOnSuccess(localDataStore::saveArticles).onErrorResumeNext(localDataStore.getArticles());
    }

}
