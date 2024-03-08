package com.example.santo.views.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.santo.R;
import com.example.santo.databinding.ActivityMainBinding;
import com.example.santo.services.models.WeiredData;
import com.example.santo.viewmodel.WeiredViewModel;
import com.example.santo.views.adapters.WeiredAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    WeiredViewModel viewModel;
    WeiredAdapter adapter;

    List<WeiredData> mymodelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.weiredRecyclerview.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel = new ViewModelProvider(this).get(WeiredViewModel.class);

        viewModel.getAllWeired().observe(this, new Observer<List<WeiredData>>() {
            @Override
            public void onChanged(List<WeiredData> weiredData) {
                mymodelList = weiredData;
                adapter = new WeiredAdapter(MainActivity.this, weiredData);

                binding.weiredRecyclerview.setAdapter(adapter);
                binding.weiredRecyclerview.setVisibility(View.VISIBLE);
                binding.weiredProgressbar.setVisibility(View.GONE);

            }
        });

    }
}