package com.example.tablesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TableRecyclerViewAdapter  extends  RecyclerView.Adapter<TableRecyclerViewAdapter.ViewHolder>

{
    List<String> mData;
    LayoutInflater mLayoutInflator;

    TableRecyclerViewAdapter(List<String> data, Context context){
        this.mData=data;
        this.mLayoutInflator=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.recyclerview_row_table,parent ,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String tableVal =mData.get(position);
        holder.mTextViewTables.setText(tableVal);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView mTextViewTables;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewTables=itemView.findViewById(R.id.tv_table);
        }
    }
}
