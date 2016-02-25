package com.samset.recyclerviewpagerexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.samset.recyclerpager.RecyclerViewPager;
import com.samset.recyclerviewpagerexample.adapter.LayoutAdapter;


public class SimpleFlipperActivity extends Activity {
    protected RecyclerViewPager simpleRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_single_fling_pager);
        Log.e("SingleFlingPager"," Step 1");
        initViewPager();
    }

    protected void initViewPager() {
        simpleRecycler = (RecyclerViewPager)findViewById(R.id.viewpager);
        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);

        simpleRecycler.setLayoutManager(layout);
        simpleRecycler.setAdapter(new LayoutAdapter(this, simpleRecycler));

        simpleRecycler.setHasFixedSize(true);
        simpleRecycler.setLongClickable(true);
        Log.e("SingleFlingPager", " Step 3");
        simpleRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
//                updateState(scrollState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
//                mPositionText.setText("First: " + mRecyclerViewPager.getFirstVisiblePosition());
                Log.e("SingleFlingPager", " Step 4");
                int childCount = simpleRecycler.getChildCount();
                int width = simpleRecycler.getChildAt(0).getWidth();
                int padding = (simpleRecycler.getWidth() - width) / 2;
//                mCountText.setText("Count: " + childCount);

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
        simpleRecycler.addOnPageChangedListener(new RecyclerViewPager.OnPageChangedListener() {
            @Override
            public void OnPageChanged(int oldPosition, int newPosition) {
                Log.d("test", "oldPosition:" + oldPosition + " newPosition:" + newPosition);
                Log.e("SingleFlingPager", " Step 5");
            }
        });

        simpleRecycler.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                Log.e("SingleFlingPager", " Step 6");

                if (simpleRecycler.getChildCount() < 3) {
                    if (simpleRecycler.getChildAt(1) != null) {
                        if (simpleRecycler.getCurrentPosition() == 0) {
                            View v1 = simpleRecycler.getChildAt(1);
                            v1.setScaleY(0.9f);
                            v1.setScaleX(0.9f);
                        } else {
                            View v1 = simpleRecycler.getChildAt(0);
                            v1.setScaleY(0.9f);
                            v1.setScaleX(0.9f);
                        }
                    }
                } else {
                    if (simpleRecycler.getChildAt(0) != null) {
                        View v0 = simpleRecycler.getChildAt(0);
                        v0.setScaleY(0.9f);
                        v0.setScaleX(0.9f);
                    }
                    if (simpleRecycler.getChildAt(2) != null) {
                        View v2 = simpleRecycler.getChildAt(2);
                        v2.setScaleY(0.9f);
                        v2.setScaleX(0.9f);
                    }
                }

            }
        });
    }
}
