package com.samset.recyclerviewpagerexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HomeAdapter leaderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        leaderAdapter = new HomeAdapter();
        recyclerView.setAdapter(leaderAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder>
    {
        String row[]={"Simple Flipper","Gallery Flipper","Loop Pager","Reverse Flipper","Vertical Flipper","Reverse Vertical","Custom Filpper"};
        public HomeAdapter()
        {

        }

        @Override
        public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.home_item, parent, false);
            return new HomeHolder(view,viewType);
        }

        @Override
        public void onBindViewHolder(HomeHolder holder, final int position) {
            holder.title.setText(row[position]);
            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = null;
                    if (position==0)
                    {
                        intent=new Intent(MainActivity.this,SimpleFlipperActivity.class);
                    }else if (position==1)
                    {
                        intent=new Intent(MainActivity.this,GalleryFlipperActivity.class);
                    }else if (position==2)
                    {
                        intent=new Intent(MainActivity.this,LoopPagerActivity.class);
                    }else if (position==3)
                    {
                        intent=new Intent(MainActivity.this,ReverseSimpleFlipperActivity.class);
                    }else if (position==4)
                    {
                        intent=new Intent(MainActivity.this,VerticalPagerActivity.class);
                    }
                    else if (position==5)
                    {
                        intent=new Intent(MainActivity.this,ReverseVerticalPagerActivity.class);
                    }else if (position==6)
                    {
                        intent=new Intent(MainActivity.this,CustomFlipper.class);
                    }
                    startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return row.length;
        }

        public class HomeHolder extends RecyclerView.ViewHolder
        {
         TextView title;
            public HomeHolder(View itemView, final int pos) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.item);

            }
        }
    }
}
