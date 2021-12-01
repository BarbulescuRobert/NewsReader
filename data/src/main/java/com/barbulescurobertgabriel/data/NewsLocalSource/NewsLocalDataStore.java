package com.barbulescurobertgabriel.data.NewsLocalSource;

import com.barbulescurobertgabriel.data.NewsLocalSource.mapper.ArticleEntityToArticleMapper;
import com.barbulescurobertgabriel.data.features.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class NewsLocalDataStore {

    private final ArticlesDao dao;

    public NewsLocalDataStore(ArticlesDao dao) {
        this.dao = dao;
    }

    public Single<List<Article>> getArticles() {
        return dao.queryArticles().map(new ArticleEntityToArticleMapper());
    }

    public Single<ArticleEntity> getToDoItem(int id) {
        return dao.queryArticleItem(id);
    }

    public Completable deleteToDoItem(int id) {
        return dao.deleteArticleItem(id);
    }


    public void saveArticles(List<Article> articles) {
        List<ArticleEntity> articleEntities = new ArrayList<>();

        for(Article a : articles)
        {
            ArticleEntity b = new ArticleEntity();
            b.title = a.title;
            b.content = a.content;
            b.imageUrl = a.imageUrl;
            articleEntities.add(b);
        }
        dao.insertArticles(articleEntities).observeOn(Schedulers.io()).subscribe();
    }
}
