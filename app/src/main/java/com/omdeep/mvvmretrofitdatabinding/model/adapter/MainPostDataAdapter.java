package com.omdeep.mvvmretrofitdatabinding.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.omdeep.mvvmretrofitdatabinding.R;
import com.omdeep.mvvmretrofitdatabinding.databinding.LayoutPostDataItemBinding;
import com.omdeep.mvvmretrofitdatabinding.model.pojo.PostData;

import java.util.List;

public class MainPostDataAdapter extends RecyclerView.Adapter<MainPostDataAdapter.MyViewHolder> {
    private Context context;
    private List<PostData> postsResponseList;

    public MainPostDataAdapter(Context context, List<PostData> postsResponseList) {
        this.context = context;
        this.postsResponseList = postsResponseList;
    }

    @NonNull
    @Override
    public MainPostDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutPostDataItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_post_data_item, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainPostDataAdapter.MyViewHolder holder, int position) {
        holder.binding.setPostDatas(postsResponseList.get(position));
    }

    @Override
    public int getItemCount() {
        return postsResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private LayoutPostDataItemBinding binding;
        public MyViewHolder(LayoutPostDataItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
