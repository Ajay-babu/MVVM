package com.omdeep.mvvmretrofitdatabinding.model.pojo;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;
import com.omdeep.mvvmretrofitdatabinding.BR;

public class PostData extends BaseObservable {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
//        notifyPropertyChanged(BR.userId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
//        notifyPropertyChanged(BR.id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
//        notifyPropertyChanged(BR.title);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
//        notifyPropertyChanged(BR.body);
    }
}