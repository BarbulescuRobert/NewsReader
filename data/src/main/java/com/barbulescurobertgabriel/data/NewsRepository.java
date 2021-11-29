package com.barbulescurobertgabriel.data;

import com.barbulescurobertgabriel.data.features.news.model.Article;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

/**
 * Created by mihai.mecea on 03.May.2020
 */
public interface NewsRepository {

    @NonNull
    Single<List<Article>> getNewsArticles();

}
