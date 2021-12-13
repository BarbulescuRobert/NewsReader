package com.barbulescurobertgabriel.newsreader.feature.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.barbulescurobertgabriel.newsreader.R;
import com.barbulescurobertgabriel.newsreader.feature.newslist.fragment.NewsListFragment;

public class NewsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsListFragment.newInstance())
                    .commitNow();
        }
    }
}