package com.example.ffff;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private  MyAdapter madapter;
    public TextView tid;
    public TextView tcountry;

    public CountryViewHolder(View item, MyAdapter adapter) {
        super(item);
        this.madapter = adapter;
        this.tid = item.findViewById(R.id.tid);
        item.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String msg = tid.getText()+ "|" + tcountry.getText();
        Toast.makeText(v.getContext(),msg, Toast.LENGTH_SHORT).show();

    }
}
