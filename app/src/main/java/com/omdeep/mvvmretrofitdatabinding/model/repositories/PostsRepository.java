package com.omdeep.mvvmretrofitdatabinding.model.repositories;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.omdeep.mvvmretrofitdatabinding.model.ApiEndPoints;
import com.omdeep.mvvmretrofitdatabinding.model.RetrofitInstance;
import com.omdeep.mvvmretrofitdatabinding.model.pojo.PostData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsRepository {
    private Application application;
    private MutableLiveData<List<PostData>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public PostsRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<PostData>> getPostsDataInRepo() {
        isLoading.postValue(true);
        ApiEndPoints apiName = RetrofitInstance.getInstance(ApiEndPoints.class);
        Call<List<PostData>> call = apiName.getPostsData();

        call.enqueue(new Callback<List<PostData>>() {
            @Override
            public void onResponse(Call<List<PostData>> call, Response<List<PostData>> response) {
                isLoading.postValue(false);
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostData>> call, Throwable t) {
                isLoading.postValue(false);
            }
        });
        return mutableLiveData;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}

