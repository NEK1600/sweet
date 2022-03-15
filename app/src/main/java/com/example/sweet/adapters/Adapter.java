package com.example.sweet.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.Adapter2> {


    @NonNull
    @Override
    public Adapter2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2 holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Adapter2 extends RecyclerView.ViewHolder {
        public Adapter2(@NonNull View itemView) {
            super(itemView);
        }
    }
}
