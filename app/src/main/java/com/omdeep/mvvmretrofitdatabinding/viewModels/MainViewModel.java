package com.omdeep.mvvmretrofitdatabinding.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.omdeep.mvvmretrofitdatabinding.model.pojo.PostData;
import com.omdeep.mvvmretrofitdatabinding.model.repositories.PostsRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private PostsRepository postsRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        postsRepository = new PostsRepository(application);
    }

    public MutableLiveData<List<PostData>> getPostsData() {
        return postsRepository.getPostsDataInRepo();
    }

    public MutableLiveData<Boolean> isLoading() {
        return postsRepository.getIsLoading();
    }
}
