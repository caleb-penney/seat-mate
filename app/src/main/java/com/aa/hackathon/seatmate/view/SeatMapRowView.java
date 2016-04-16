package com.aa.hackathon.seatmate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aa.hackathon.seatmate.R;
import com.aa.hackathon.seatmate.Seat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caleb on 4/15/16.
 */
public class SeatMapRowView extends LinearLayout {

    private TextView mRowNumberTextView;

    private int mRowNumber;
    private Map<String, Seat> mSeatMap = new HashMap<>();
    private OnClickListener mSeatOnClickListener;

    public SeatMapRowView(Context context) {
        super(context);
        init(context, null, null, null);
    }

    public SeatMapRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, null, null);
    }

    public SeatMapRowView(Context context, Map<String, Seat> seatMap, OnClickListener seatOnClickListener) {
        super(context, null);
        init(context, null, seatMap, seatOnClickListener);
    }

    private void init(Context context, AttributeSet attrs, Map<String, Seat> seatMap, OnClickListener seatOnClickListener) {
        if (seatMap != null) {
            mSeatMap = seatMap;
        }
        setSeatOnClickListener(seatOnClickListener);

        setOrientation(HORIZONTAL);
        LayoutInflater.from(context).inflate(R.layout.seatmap_row, this, true);
        mRowNumberTextView = (TextView) findViewById(R.id.seatmapRow_rowNumberTextView);
        if (mSeatOnClickListener != null) {
            for (int i = 0; i < 7; i++) {
                if (i != 3) {
                    View seatView = getChildAt(i);
                    if (seatView instanceof SeatView) {
                        seatView.setOnClickListener(mSeatOnClickListener);
                        String key = String.valueOf(mRowNumber) + mapIndexToLetter(i);
                        seatView.setTag(mSeatMap.get(key));
                    }
                }
            }
        }
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

    public void setSeatOnClickListener(OnClickListener seatOnClickListener) {
        mSeatOnClickListener = seatOnClickListener;
    }

    public SeatView getSeatViewInColumn(int column) {
        int actualColumnIndex = column;
        switch (actualColumnIndex) {
            case 0:
            case 1:
            case 2:
                actualColumnIndex -= 1;
                return (SeatView) getChildAt(actualColumnIndex);

            case 3:
            case 4:
            case 5:
                actualColumnIndex += 1;
                return (SeatView) getChildAt(actualColumnIndex);

            default:
                return (SeatView) getChildAt(0);
        }
    }

    private String mapIndexToLetter(int index) {
        switch (index) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            case 6:
                return "F";
            default:
                return "A";
        }
    }
}
