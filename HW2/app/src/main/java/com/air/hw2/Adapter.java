package com.air.hw2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    public List<Item> mData;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public CheckBox checkBox;
        public ViewHolder(View view){
            super(view);
            textView = (TextView)view.findViewById(R.id.item_text);
            checkBox = (CheckBox)view.findViewById(R.id.item_chcekbox);
        }
    }
    public Adapter(List<Item> data){
        mData = data;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position){
        Item item = mData.get(position);
        holder.textView.setText(item.getText());
        holder.checkBox.setChecked(item.isCheck());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                boolean bool = ((CheckBox) view).isChecked();
                holder.checkBox.setChecked(bool);
                mData.get(position).setCheck(bool);

            }
        });
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }



}