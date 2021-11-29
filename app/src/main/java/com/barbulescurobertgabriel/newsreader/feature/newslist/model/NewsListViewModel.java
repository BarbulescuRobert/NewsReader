package com.barbulescurobertgabriel.newsreader.feature.newslist.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
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
    public final List<ArticleItemViewModel> newsList = new ArrayList<>();
    private final static String LINK = "https://newsapi.org/";
    private final NewsRepository repo;

    public final SingleLiveEvent<Throwable> error;
    public final SingleLiveEvent<String> openLink;

    public NewsListViewModel(Application application, NewsRepository repo) {
        super(application);
        this.repo = repo;
        this.error = new SingleLiveEvent<>();
        this.openLink = new SingleLiveEvent<>();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh()
    {
        repo.getNewsArticles()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        this::onNewsArticlesReceived,
                        this::onNewsArticlesError
                );
    }
    private void onNewsArticlesReceived(@NonNull List<Article> articles) {
        for(Article a : articles)
            newsList.add(new ArticleItemViewModel(a.title, a.content, a.imageUrl));
    }

    private void onNewsArticlesError(Throwable throwable) {
        error.setValue(throwable);
    }

    public void onPoweredBySelected() {
        openLink.setValue(LINK);
    }

}
