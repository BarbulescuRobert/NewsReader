package com.barbulescurobertgabriel.newsreader.feature.newslist.model;

import com.barbulescurobertgabriel.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;

public class NewsArticlesToViewModelMapper implements Function<List<Article>, List<ArticleItemViewModel>>{
    @Override
    public List<ArticleItemViewModel> apply(List<Article> articles) {
        List<ArticleItemViewModel> items = new ArrayList<>();

        for(Article a : articles)
            items.add( new ArticleItemViewModel(a.title, a.content, a.imageUrl));

        return items;
    }
}
