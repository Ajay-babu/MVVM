package com.omdeep.mvvmretrofitdatabinding.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.omdeep.mvvmretrofitdatabinding.R;
import com.omdeep.mvvmretrofitdatabinding.databinding.ActivityMainBinding;
import com.omdeep.mvvmretrofitdatabinding.model.adapter.MainPostDataAdapter;
import com.omdeep.mvvmretrofitdatabinding.model.pojo.PostData;
import com.omdeep.mvvmretrofitdatabinding.viewModels.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading....");

        viewModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading) progressDialog.show();
                else progressDialog.dismiss();
            }
        });
        viewModel.getPostsData().observe(this, new Observer<List<PostData>>() {
            @Override
            public void onChanged(List<PostData> postResponses) {
                MainPostDataAdapter adapter = new MainPostDataAdapter(MainActivity.this, postResponses);
                binding.recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}