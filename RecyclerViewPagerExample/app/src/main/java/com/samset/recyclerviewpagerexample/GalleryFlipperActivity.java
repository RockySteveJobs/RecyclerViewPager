package com.samset.recyclerviewpagerexample;

import android.os.Bundle;

public class GalleryFlipperActivity extends SimpleFlipperActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simpleRecycler.setSinglePageFling(false);
    }
}
