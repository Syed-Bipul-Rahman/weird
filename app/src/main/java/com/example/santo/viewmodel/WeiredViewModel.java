package com.example.santo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.santo.services.models.WeiredData;
import com.example.santo.services.repositories.AllWeiredRepository;

import java.util.List;

public class WeiredViewModel extends AndroidViewModel {
    AllWeiredRepository allWeiredRepository;

    public WeiredViewModel(@NonNull Application application) {
        super(application);

        allWeiredRepository = AllWeiredRepository.getInstance(application);

    }

    public LiveData<List<WeiredData>> getAllWeired() {
        return allWeiredRepository.getWeiredList();
    }
}
