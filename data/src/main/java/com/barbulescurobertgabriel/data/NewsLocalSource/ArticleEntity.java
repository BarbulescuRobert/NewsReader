package com.barbulescurobertgabriel.data.NewsLocalSource;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news")
public class ArticleEntity {

    @PrimaryKey(autoGenerate = true)
    @Nullable
    public Integer id;

    public String imageUrl, title, content;

}