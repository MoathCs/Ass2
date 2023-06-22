package com.example.assignmenttowapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class AdapterRec
        extends RecyclerView.Adapter<AdapterRec.ViewHolder>{

    private ArrayList<String> dataSet;

    public AdapterRec(ArrayList<String> dataSet) {
        this.dataSet = dataSet;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = dataSet.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }
    }
}