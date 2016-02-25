package com.samset.recyclerviewpagerexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samset.recyclerviewpagerexample.R;

/**
 * Created by weesync on 24/02/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyHolder> {
    Context context;
    static int VIEW_TYPE_FIRST = 0;
    static int VIEW_TYPE_SECOND = 1;
    static int VIEW_TYPE_THIRD = 2;
    static int VIEW_TYPE_FOURTH = 3;
    static int VIEW_TYPE_FIFTH = 4;

    public CustomAdapter(Context ctx) {
        this.context = ctx;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        MyHolder myHolder;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(context).inflate(R.layout.layout1,parent, false);
                myHolder = new MyHolder(view, viewType);
                VIEW_TYPE_FIRST=0;
                return myHolder;
            case 1:
                view = LayoutInflater.from(context).inflate(R.layout.layout2,parent, false);
                myHolder = new MyHolder(view, viewType);
                VIEW_TYPE_SECOND=1;
                return myHolder;
            case 2:
                view = LayoutInflater.from(context).inflate(R.layout.layout3,parent, false);
                myHolder = new MyHolder(view, viewType);
                VIEW_TYPE_THIRD=2;
                return myHolder;
            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.layout4,parent, false);
                myHolder = new MyHolder(view, viewType);
                VIEW_TYPE_FOURTH=3;
                return myHolder;
            case 4:
                view = LayoutInflater.from(context).inflate(R.layout.layout5,parent, false);
                myHolder = new MyHolder(view, viewType);
                VIEW_TYPE_FIFTH=4;
                return myHolder;


        }


        return null;
    }

    @Override
    public int getItemViewType(int position) {

        /*You can set your own view basis of position*/
        if (position==0)
        {
            return VIEW_TYPE_FIRST;
        }else if (position==1)
        {
            return VIEW_TYPE_SECOND;
        }else if (position==2)
        {
            return VIEW_TYPE_THIRD;
        }else if (position==3)
        {
            return VIEW_TYPE_FOURTH;
        }else if (position==4)
        {
            return VIEW_TYPE_FIFTH;
        }
        return VIEW_TYPE_FIRST;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView, int position) {
            super(itemView);
            if (position == 0) {

            }
        }
    }
}
