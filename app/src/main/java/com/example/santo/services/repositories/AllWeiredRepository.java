package com.example.santo.services.repositories;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.santo.services.models.WeiredData;
import com.example.santo.services.models.WeiredResponse;
import com.example.santo.services.network.ApiClient;
import com.example.santo.services.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllWeiredRepository {
    private static Context mContext;
    private static AllWeiredRepository instance;
    private List<WeiredData> mWeiredData;
    private WeiredResponse weiredResponse;
    private MutableLiveData<List<WeiredData>> mLiveData; // Fix: Specify the type parameter

    public static AllWeiredRepository getInstance(Context context) {
        if (instance == null) {
            mContext = context;
            instance = new AllWeiredRepository();
        }
        return instance;
    }

    public MutableLiveData<List<WeiredData>> getWeiredList() {
        if (mLiveData == null) {
            mLiveData = new MutableLiveData<>();
        }

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<WeiredResponse> call = apiService.getanimals();

        call.enqueue(new Callback<WeiredResponse>() {
            @Override
            public void onResponse(Call<WeiredResponse> call, Response<WeiredResponse> response) {
                weiredResponse = response.body();
                if (weiredResponse != null) { // Fix: Check for null response
                    mWeiredData = weiredResponse.getData();
                    mLiveData.setValue(mWeiredData);
                }
            }

            @Override
            public void onFailure(Call<WeiredResponse> call, Throwable t) {
                Toast.makeText(mContext.getApplicationContext(), "Data can't be loaded...", Toast.LENGTH_SHORT).show();
            }
        });

        return mLiveData;
    }
}
