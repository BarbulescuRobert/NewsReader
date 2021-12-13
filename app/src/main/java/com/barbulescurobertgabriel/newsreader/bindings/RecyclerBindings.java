package com.barbulescurobertgabriel.newsreader.bindings;


import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.barbulescurobertgabriel.newsreader.feature.newslist.adapter.ArticleItemAdapter;
import com.barbulescurobertgabriel.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.List;

public class RecyclerBindings {

    @BindingAdapter({"articles"})
    public static void addFeedItems(RecyclerView recyclerView, List<ArticleItemViewModel> articles) {
        ArticleItemAdapter articlesAdapter = (ArticleItemAdapter) recyclerView.getAdapter();

        if (articlesAdapter == null) {
            articlesAdapter = new ArticleItemAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(articlesAdapter);
        }

        articlesAdapter.setItems(articles);
    }
}
