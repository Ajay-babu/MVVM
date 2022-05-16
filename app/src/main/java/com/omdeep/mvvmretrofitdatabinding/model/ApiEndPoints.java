package com.omdeep.mvvmretrofitdatabinding.model;

import com.omdeep.mvvmretrofitdatabinding.model.pojo.PostData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoints {
    @GET("/posts")
    Call<List<PostData>> getPostsData();
//
//    @GET("/users")
//    Call<List<UserResponse>> getUsersData(String userName);
}
