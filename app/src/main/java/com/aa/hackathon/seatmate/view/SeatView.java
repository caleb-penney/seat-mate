package com.aa.hackathon.seatmate.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.aa.hackathon.seatmate.R;
import com.aa.hackathon.seatmate.Seat;

/**
 * Created by caleb on 4/15/16.
 */
public class SeatView extends View {

    private Context mContext;
    private Seat mSeat;

    public SeatView(Context context) {
        super(context);
        init(context, null, null);
    }

    public SeatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, null);
    }

    public SeatView(Context context, Seat seat) {
        super(context);
        init(context, null, seat);
    }

    private void init(Context context, AttributeSet attrs, Seat seat) {
        mContext = context;

        setSeat(seat);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(width, width);
    }

    public void clearSelection() {
        LayerDrawable bgDrawable = (LayerDrawable) getBackground();
        Drawable drawable = bgDrawable.getDrawable(1);
        drawable.setAlpha(0);
    }

    public void setSelected() {
        LayerDrawable bgDrawable = (LayerDrawable) getBackground();
        Drawable drawable = bgDrawable.getDrawable(1);
        drawable.setAlpha(255);
    }

    public Seat getSeat() {
        return mSeat;
    }

    public void setSeat(Seat seat) {
        mSeat = seat;
        if (seat != null) {
            setBackground(determineBackgroundDrawableForSeatType(seat.getSeatType()));
            clearSelection();
        }
    }

    private Drawable determineBackgroundDrawableForSeatType(Seat.SeatType seatType) {
        switch (seatType) {
            case PREFERRED:
                Log.d("SeatView", "Preferred");
                return ContextCompat.getDrawable(mContext, R.drawable.preferred_background_drawable);

            case MAIN_CABIN_EXTRA:
                Log.d("SeatView", "Preferred");
                return ContextCompat.getDrawable(mContext, R.drawable.mce_background_drawable);

            case STANDARD:
            default:
                Log.d("SeatView", "Preferred");
                return ContextCompat.getDrawable(mContext, R.drawable.standard_background_drawable);
        }
    }
}
