package com.example.tablesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewTables;
    public  void generateDataInRecyclerView(int tableNum){
        ArrayList<String> tables =new ArrayList<>();
        for(int i=1;i<=10;i++){
            tables.add(Integer.toString(i*tableNum));
        }
        mRecyclerViewTables.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewTables.setAdapter(new TableRecyclerViewAdapter(tables,this  ));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerViewTables=findViewById(R.id.recyclerView);
        SeekBar mSeekBarTables =findViewById(R.id.seekBar);
        int max = 20;
        int min =1;
        int startingPosition = 10;
        mSeekBarTables.setMax(max);
        mSeekBarTables.setProgress(startingPosition);

        mSeekBarTables.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 int tableNum;
                 if(progress<min){
                     tableNum=min;
                     mSeekBarTables.setProgress(tableNum);
                 }else{
                     tableNum= progress;
                 }
                Log.d("Seek","value:"+tableNum);
                 generateDataInRecyclerView(tableNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}