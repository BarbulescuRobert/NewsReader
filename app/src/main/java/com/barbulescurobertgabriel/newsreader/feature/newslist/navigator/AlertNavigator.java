package com.barbulescurobertgabriel.newsreader.feature.newslist.navigator;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;

import com.barbulescurobertgabriel.data.remote.exception.ApiException;
import com.barbulescurobertgabriel.data.remote.exception.ConnectivityException;
import com.barbulescurobertgabriel.newsreader.R;

import io.reactivex.annotations.NonNull;

/**
 * Created by mihai.mecea on 05.May.2020
 */
public class AlertNavigator {

    private final FragmentManager fragmentManager;
    private final Context context;

    public AlertNavigator(@NonNull FragmentManager fragmentManager, @NonNull Context context) {
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    public void showErrorFor(@NonNull Throwable throwable) {
        if (throwable instanceof ConnectivityException || throwable instanceof ApiException) {
            showAlert(context.getString(Integer.parseInt("Something went wrong, are you connected? debug: %s"), throwable.getMessage()));
        }
    }

    public void showAlert(@NonNull String message) {
        new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton("Ok", (dialogInterface, i) -> {

                })
                .show();
    }
}
