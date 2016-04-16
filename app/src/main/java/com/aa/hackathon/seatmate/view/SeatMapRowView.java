package com.aa.hackathon.seatmate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aa.hackathon.seatmate.R;

/**
 * Created by caleb on 4/15/16.
 */
public class SeatMapRowView extends LinearLayout {

    private int mRowNumber;
    private TextView mRowNumberTextView;

    public SeatMapRowView(Context context) {
        super(context);
        init(context, null);
    }

    public SeatMapRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        LayoutInflater.from(context).inflate(R.layout.seatmap_row, this, true);
        mRowNumberTextView = (TextView) findViewById(R.id.seatmapRow_rowNumberTextView);
    }

    public void setRowNumber(int rowNumber) {
        mRowNumber = rowNumber;
        if (mRowNumberTextView != null) {
            mRowNumberTextView.setText(String.valueOf(mRowNumber));
        } else {
            mRowNumberTextView = (TextView) findViewById(R.id.seatmapRow_rowNumberTextView);
            mRowNumberTextView.setText(String.valueOf(mRowNumber));
        }
    }
}
