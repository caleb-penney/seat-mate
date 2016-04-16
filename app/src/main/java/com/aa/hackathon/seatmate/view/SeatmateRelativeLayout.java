package com.aa.hackathon.seatmate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * Created by caleb on 4/16/16.
 */
public class SeatmateRelativeLayout extends RelativeLayout {

    public interface OnSizeChangedListener {
        void onSizeChanged(int height);
    }

    private OnSizeChangedListener mOnSizeChangedListener;

    public SeatmateRelativeLayout(Context context) {
        super(context);
    }

    public SeatmateRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mOnSizeChangedListener != null) {
            Log.d("SeatmateImageView", "onSizeChanged");
            mOnSizeChangedListener.onSizeChanged(h);
        }
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        mOnSizeChangedListener = onSizeChangedListener;
    }
}
