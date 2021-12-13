package com.barbulescurobertgabriel.data.NewsLocalSource;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface ArticlesDao {

    @Query("SELECT * FROM news")
    Single<List<ArticleEntity>> queryArticles();

    @Query("SELECT * FROM news where id= :id")
    Single<ArticleEntity> queryArticleItem(int id);

    @Query("DELETE FROM news where id=:id")
    Completable deleteArticleItem(int id);

    @Query("DELETE FROM news")
    Completable deleteAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticles(List<ArticleEntity> articles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertArticle(ArticleEntity article);

    @Query("UPDATE news SET imageUrl = :imageUrl, title = :title, content = :content where id=:id")
    Completable updateRow(String imageUrl, String title, String content, int id);

}
