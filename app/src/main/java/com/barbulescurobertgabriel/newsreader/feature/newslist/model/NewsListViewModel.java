package com.barbulescurobertgabriel.newsreader.feature.newslist.model;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsListViewModel extends ViewModel implements LifecycleObserver {
    @NonNull
    public final List<ArticleItemViewModel> newsList = new ArrayList<>();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void refresh()
    {
        newsList.add(new ArticleItemViewModel("Article1", "Content1"));
        newsList.add(new ArticleItemViewModel("Article2", "Content2"));
    }


}
