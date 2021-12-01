package com.barbulescurobertgabriel.data.di;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.barbulescurobertgabriel.data.NewsLocalSource.NewsDatabase;
import com.barbulescurobertgabriel.data.NewsLocalSource.NewsLocalDataStore;
import com.barbulescurobertgabriel.data.NewsRepository;
import com.barbulescurobertgabriel.data.features.news.NewsRepositoryImpl;
import com.barbulescurobertgabriel.data.features.news.remote.NewsRemoteSource;
import com.barbulescurobertgabriel.data.remote.HttpClientFactory;

import io.reactivex.annotations.NonNull;

public class RepoModule {
    @NonNull
    private Context context;
    @NonNull
    private final HttpClientFactory httpClientFactory;
    private volatile NewsDatabase database;

    public RepoModule(@NonNull Application application) {
        this.context = application.getApplicationContext();
        this.httpClientFactory = new HttpClientFactory();
    }

    public NewsRepository provideNewsRepository() {
        return new NewsRepositoryImpl(provideNewsRemoteSource(), provideLocalDataStore());
    }

    private NewsRemoteSource provideNewsRemoteSource() {
        return new NewsRemoteSource(httpClientFactory.getNewsApi());
    }
    NewsLocalDataStore provideLocalDataStore() {
        NewsDatabase database = getInstance();
        return new NewsLocalDataStore(database.toDoDao());
    }

    NewsDatabase getInstance() {
        if (database == null) {
            synchronized (NewsDatabase.class) {
                if (database == null) {
                    database = Room.databaseBuilder(context,
                            NewsDatabase.class, "Sample.db")
                            .build();
                }
            }
        }
        return database;
    }
}
