package com.example.sweet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sweet.R;
import com.example.sweet.base.Manager;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Adapter2> {
    private Context context;
    private List<String> listAdapter;
    ArrayList<Integer> listId;

    public Adapter(Context context){
        this.context = context;
        listAdapter = new ArrayList<>();
        listId = new ArrayList<>();
    }

    @NonNull
    @Override
    public Adapter2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_delite, parent, false);
        return new Adapter2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter2 holder, int position) {
        holder.set(listAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        return listAdapter.size();
    }

    public class Adapter2 extends RecyclerView.ViewHolder {
        private TextView textView;

        public Adapter2(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textRc);
        }
        public void set(String product){
            textView.setText(product);
        }
    }

    public void update(List<String> list2, List<Double> list3){
        listAdapter.clear();
        listAdapter.addAll(list2);
        notifyDataSetChanged();
    }


    public void remove(int pos, Manager manager){

        listId = manager.readBaseId();
        Integer integer = listId.get(pos);
        manager.delete(integer);
        listAdapter.remove(pos);
        notifyItemRangeChanged(0, listAdapter.size());
        notifyItemRemoved(pos);
    }

}





































