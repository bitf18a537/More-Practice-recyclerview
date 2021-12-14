package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Friends> friendsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Friends f0 = new Friends(1,"Asad", 1980, "Giglgit",R.drawable.ic_launcher_background);
        Friends f1 = new Friends(2,"Zubair", 1981, "Lahore", R.drawable.ic_launcher_background);
        Friends f2 = new Friends(3,"Musa", 1980, "Quetta", R.drawable.ic_launcher_background);
        Friends f3 = new Friends(4,"Nadeem",1987,"Peshawar", R.drawable.ic_launcher_background);
        Friends f4 = new Friends(5,"Shahid", 1980, "Karachi", R.drawable.ic_launcher_background);
        Friends f5 = new Friends(6,"Zia",1987,"Faisalabad ", R.drawable.ic_launcher_background);
        Friends f6 = new Friends(7,"Badar", 1980, "Rawalpindi", R.drawable.ic_launcher_background);
        Friends f7 = new Friends(8,"Hashim",1997,"Karachi", R.drawable.ic_launcher_background);
        Friends f8 = new Friends(9,"Salman",1980,"Quetta", R.drawable.ic_launcher_background);
        Friends f9 = new Friends(10,"Rizwan",1982,"Kasur", R.drawable.ic_launcher_background);
        Friends f10 = new Friends(11,"Junaid",1977,"Islamabad", R.drawable.ic_launcher_background);
        Friends f11 = new Friends(12,"Waseem",1967,"Rawalpindi", R.drawable.ic_launcher_background);


        friendsList.addAll(Arrays.asList(new Friends[]{f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,
                f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,
                f0,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11}));
        recyclerView = findViewById(R.id.myrecyclerView);
        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new myRecyclerViewAdapter(friendsList) ;
        recyclerView.setAdapter(adapter);

        layoutManager  = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        ////layoutManagerGrid = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

    }

    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.data=friendsList.get(position);
        holder.textViewFriendName.setText(holder.data.getName());
        holder.textViewdateFriend.setText(String.valueOf(holder.data.getDob()));
        holder.imageViewFriend.setImageResource(holder.data.getImageId());
        holder.textViewCity.setText(holder.data.getCity());}

    public int getItemCount() {
        return friendsList.size();}

}