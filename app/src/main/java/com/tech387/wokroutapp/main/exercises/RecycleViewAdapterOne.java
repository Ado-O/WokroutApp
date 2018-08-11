package com.tech387.wokroutapp.main.exercises;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.databinding.ListItemBinding;

import java.util.List;

public class RecycleViewAdapterOne extends RecyclerView.Adapter {

    private List<Exercise> mList;
    private LayoutInflater mInflater;
    private Context mContext;

    public RecycleViewAdapterOne(Context context, List<Exercise> list) {
        mInflater = LayoutInflater.from(context);
        mList = list;

        mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExerciseViewHolder(ListItemBinding.inflate(mInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((ExerciseViewHolder) holder).setup(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

