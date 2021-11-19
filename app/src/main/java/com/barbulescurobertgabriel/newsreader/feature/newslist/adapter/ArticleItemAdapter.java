package com.barbulescurobertgabriel.newsreader.feature.newslist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barbulescurobertgabriel.newsreader.databinding.ArticleItemBinding;
import com.barbulescurobertgabriel.newsreader.feature.newslist.model.ArticleItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleItemAdapter extends RecyclerView.Adapter<ArticleItemAdapter.ArticleItemViewHolder> {

    private List<ArticleItemViewModel> articleModelList;

    public ArticleItemAdapter() {
        this.articleModelList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ArticleItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ArticleItemBinding newsItemBinding = ArticleItemBinding.inflate(layoutInflater, parent, false);
        return new ArticleItemViewHolder(newsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleItemViewHolder holder, int position) {
        holder.newsItemBinding.setViewModel(articleModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return articleModelList.size();
    }

    public void setItems(@NonNull List<ArticleItemViewModel> items) {
        this.articleModelList = items;
        notifyDataSetChanged();
    }


    public static class ArticleItemViewHolder extends RecyclerView.ViewHolder {
        private ArticleItemBinding newsItemBinding;

        public ArticleItemViewHolder(@NonNull ArticleItemBinding newsItemBinding) {
            super(newsItemBinding.getRoot());
            this.newsItemBinding = newsItemBinding;
        }
    }
}