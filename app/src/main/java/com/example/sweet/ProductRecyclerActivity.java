package com.example.sweet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.sweet.adapters.Adapter;
import com.example.sweet.base.Manager;

public class ProductRecyclerActivity extends AppCompatActivity {
    private RecyclerView rc;
    private Adapter adapter;
    private Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_recycler);

        manager = new Manager(this);

        rc = findViewById(R.id.rc);
        adapter = new Adapter(this);
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setAdapter(adapter);

        getItemHelper().attachToRecyclerView(rc);

    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.openBase();

        adapter.update(manager.readBaseName(), manager.readBaseGram());
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.closeDb();
    }

    private ItemTouchHelper getItemHelper(){
        return new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                    adapter.remove(viewHolder.getAdapterPosition(), manager);

            }
        });
    }


}




































