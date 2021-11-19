package com.barbulescurobertgabriel.newsreader.feature.newslist.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.barbulescurobertgabriel.newsreader.databinding.NewsListFragmentBinding;
import com.barbulescurobertgabriel.newsreader.feature.newslist.model.NewsListViewModel;

public class MainFragment extends Fragment {

    private NewsListViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(NewsListViewModel.class);
        getLifecycle().addObserver(mViewModel);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NewsListFragmentBinding binding = NewsListFragmentBinding.inflate(inflater,container, false);
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }
}