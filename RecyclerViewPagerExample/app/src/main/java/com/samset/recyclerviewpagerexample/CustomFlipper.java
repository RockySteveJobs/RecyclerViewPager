package com.samset.recyclerviewpagerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.samset.recyclerpager.RecyclerViewPager;
import com.samset.recyclerviewpagerexample.adapter.CustomAdapter;

public class CustomFlipper extends AppCompatActivity {
    protected RecyclerViewPager customRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_flipper);
        initViewPager();
    }
    protected void initViewPager() {
        customRecycler = (RecyclerViewPager)findViewById(R.id.viewpager);
        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);

        customRecycler.setLayoutManager(layout);
        customRecycler.setAdapter(new CustomAdapter(this));
        customRecycler.setHasFixedSize(true);
        customRecycler.setLongClickable(true);

        customRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {

                Log.e("SingleFlingPager", " Step 4");
                int childCount = customRecycler.getChildCount();
                int width = customRecycler.getChildAt(0).getWidth();
                int padding = (customRecycler.getWidth() - width) / 2;

                for (int j = 0; j < childCount; j++) {
                    View v = recyclerView.getChildAt(j);
                    //  padding  -(v.getWidth()-padding) ，
                    float rate = 0;
                    ;
                    if (v.getLeft() <= padding) {
                        if (v.getLeft() >= padding - v.getWidth()) {
                            rate = (padding - v.getLeft()) * 1f / v.getWidth();
                        } else {
                            rate = 1;
                        }
                        v.setScaleY(1 - rate * 0.1f);
                        v.setScaleX(1 - rate * 0.1f);

                    } else {
                        // padding  recyclerView.getWidth()-padding ，
                        if (v.getLeft() <= recyclerView.getWidth() - padding) {
                            rate = (recyclerView.getWidth() - padding - v.getLeft()) * 1f / v.getWidth();
                        }
                        v.setScaleY(0.9f + rate * 0.1f);
                        v.setScaleX(0.9f + rate * 0.1f);
                    }
                }
            }
        });
        customRecycler.addOnPageChangedListener(new RecyclerViewPager.OnPageChangedListener() {
            @Override
            public void OnPageChanged(int oldPosition, int newPosition) {
                Log.e("SingleFlingPager", " Step 5");
            }
        });

        customRecycler.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {


                if (customRecycler.getChildCount() < 3) {
                    if (customRecycler.getChildAt(1) != null) {
                        if (customRecycler.getCurrentPosition() == 0) {
                            View v1 = customRecycler.getChildAt(1);
                            v1.setScaleY(0.9f);
                            v1.setScaleX(0.9f);
                        } else {
                            View v1 = customRecycler.getChildAt(0);
                            v1.setScaleY(0.9f);
                            v1.setScaleX(0.9f);
                        }
                    }
                } else {
                    if (customRecycler.getChildAt(0) != null) {
                        View v0 = customRecycler.getChildAt(0);
                        v0.setScaleY(0.9f);
                        v0.setScaleX(0.9f);
                    }
                    if (customRecycler.getChildAt(2) != null) {
                        View v2 = customRecycler.getChildAt(2);
                        v2.setScaleY(0.9f);
                        v2.setScaleX(0.9f);
                    }
                }

            }
        });
    }
}
