package com.aa.hackathon.seatmate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by caleb on 4/15/16.
 */
public class SeatMapView extends ViewGroup {

    public SeatMapView(Context context) {
        super(context);
    }

    public SeatMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count - 1; i++) {
            View child = getChildAt(i);


        }
    }
}
