package com.aa.hackathon.seatmate.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.aa.hackathon.seatmate.R;

/**
 * Created by caleb on 4/15/16.
 */
public class SeatView extends View {

    private Context mContext;

    public SeatView(Context context) {
        super(context);
        init(context, null);
    }

    public SeatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;

        setBackground(ContextCompat.getDrawable(context, R.drawable.seat_background_drawable));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, width);
    }
}
