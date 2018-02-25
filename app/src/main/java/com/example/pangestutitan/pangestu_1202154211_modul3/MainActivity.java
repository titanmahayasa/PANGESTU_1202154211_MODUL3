package com.example.pangestutitan.pangestu_1202154211_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    //anggota variabel
    private RecyclerView mRecyclerView;
    private ArrayList<Water> mWaterData;
    private WaterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // menetapkan LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi ArrayList yang akan berisi data
        mWaterData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new WaterAdapter(this, mWaterData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();

        //Helper class for creating swipe to dismiss and drag and drop functionality
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                //Get the from and to position
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap the items and notify the adapter
                Collections.swap(mWaterData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //Remove the item from the dataset
                mWaterData.remove(viewHolder.getAdapterPosition());

                //Notify the adapter
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        //Attach the helper to the RecyclerView
        helper.attachToRecyclerView(mRecyclerView);
    }


    private void initializeData() {
        //Get the resources from the XML file
        String[] waterList = getResources().getStringArray(R.array.water_titles);
        String[] waterInfo = getResources().getStringArray(R.array.water_info);
        TypedArray waterImageResources =
                getResources().obtainTypedArray(R.array.water_images);

        //Clear the existing data (to avoid duplication)
        mWaterData.clear();


        //Create the ArrayList of Air Mineral with the titles and information about each merk air mineral
        for (int i = 0; i < waterList.length; i++) {
            mWaterData.add(new Water(waterList[i], waterInfo[i],
                    waterImageResources.getResourceId(i, 0)));


        }
        //recycle the typed array
        waterImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();


    }
}
