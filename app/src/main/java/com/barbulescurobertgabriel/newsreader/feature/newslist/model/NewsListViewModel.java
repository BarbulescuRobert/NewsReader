package com.barbulescurobertgabriel.newsreader.feature.newslist.model;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.OnLifecycleEvent;

import com.barbulescurobertgabriel.data.NewsRepository;
import com.barbulescurobertgabriel.data.features.news.model.Article;
import com.barbulescurobertgabriel.newsreader.R;
import com.barbulescurobertgabriel.newsreader.feature.newslist.reactive.SingleLiveEvent;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class NewsListViewModel extends AndroidViewModel implements LifecycleObserver {
    @NonNull
    public final ObservableList<ArticleItemViewModel> newsList;
    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;

    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;

    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.newsList = new ObservableArrayList<>();
        this.repo = repo;
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }

    @SuppressLint("CheckResult")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh()
    {
        repo.getNewsArticles()
                .map(new NewsArticlesToViewModelMapper())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }
    private void onNewsArticlesReceived(@NonNull List<ArticleItemViewModel> articles) {
        newsList.clear();
        newsList.addAll(articles);
    }

    private void onNewsArticlesError(Throwable throwable) {
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }

}
