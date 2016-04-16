package com.aa.hackathon.seatmate;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aa.hackathon.seatmate.Utils.DetailedCompatabilityResults;
import com.aa.hackathon.seatmate.Utils.NetworkAsyncTaskRequestToShare;
import com.aa.hackathon.seatmate.Utils.NetworkAsyncTaskSendSharedData;
import com.aa.hackathon.seatmate.Utils.ProfileCombiner;
import com.aa.hackathon.seatmate.view.SeatView;
import com.aa.hackathon.seatmate.view.SeatmateRelativeLayout;
import com.aa.hackathon.seatmate.view.SeatmateTextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1111;

    private LinearLayout mSeatmapRowLinearLayout;
    private TextView mEditPreferenceTextView;
    private SeatmateRelativeLayout mSeatmapShelf;
    private ImageView mCloseShelfImageView;
    private Button mSelectButton;
    private TextView mShelfSeatNumber;
    private TextView mShelfPrice;
    private TextView mShelfRating;
    private TextView mShelfFeatures;
    private TextView mShelfSeatType;
    private View mShelfTopBar;

    private boolean hasSeatShelfInitialized;
    private SeatView mCurrentlySelectedSeat;
    private boolean isSeatShelfShowing;
    private int mSeatmapShelfHeight;
    private AccelerateDecelerateInterpolator mInterpolator = new AccelerateDecelerateInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setViewInstances();
        mSeatmapRowLinearLayout.removeAllViews();
        setListeners();

        populateSeatLayout();
        setSupportActionBar(toolbar);

        ProfileCombiner combiner = ProfileCombiner.getInstance();

        float weightForD4 = ProfileCombiner.getCombinedValue("D", 4);
        DetailedCompatabilityResults detailResultsD4 = ProfileCombiner.getLastCompatabilityDetail();

        float weightForA5 = ProfileCombiner.getCombinedValue("A", 5);
        DetailedCompatabilityResults detailResultsA5 = ProfileCombiner.getLastCompatabilityDetail();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setViewInstances() {
        mSelectButton = (Button) findViewById(R.id.shelfSelectButton);
        mShelfSeatNumber = (TextView) findViewById(R.id.shelfSeatNumber);
        mSeatmapRowLinearLayout = (LinearLayout) findViewById(R.id.mainSeatmapRowLinearLayout);
        mEditPreferenceTextView = (TextView) findViewById(R.id.preferenceEdit);
        mSeatmapShelf = (SeatmateRelativeLayout) findViewById(R.id.seatmapShelf);
        mCloseShelfImageView = (ImageView) findViewById(R.id.shelfCloseImageView);
        mShelfPrice = (TextView) findViewById(R.id.shelfSeatPrice);
        mShelfRating = (TextView) findViewById(R.id.shelfSeatmateRating);
        mShelfFeatures = (TextView) findViewById(R.id.shelfSeatFeatures);
        mShelfSeatType = (TextView) findViewById(R.id.shelfSeatType);
        mShelfTopBar = findViewById(R.id.shelfTopBar);
    }

    private void setListeners() {
        mSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkAsyncTaskRequestToShare async = new NetworkAsyncTaskRequestToShare();
                async.execute("18063366650");

                new Timer().schedule(new TimerTask()
                {
                    @Override
                    public void run()
                    {
                        // run AsyncTask here.
                        NetworkAsyncTaskSendSharedData async2 = new NetworkAsyncTaskSendSharedData();
                        async2.execute("12145977609");

                    }
                }, 30000);
            }
        });
        mEditPreferenceTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeatmatePreferenceActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        mSeatmapShelf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        mSeatmapShelf.setOnSizeChangedListener(new SeatmateRelativeLayout.OnSizeChangedListener() {
            @Override
            public void onSizeChanged(int height) {
                mSeatmapShelfHeight = height;
                if (!hasSeatShelfInitialized) {
                    hasSeatShelfInitialized = true;
                    mSeatmapShelf.setTranslationY(height);
                }
            }
        });
        mCloseShelfImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentlySelectedSeat != null) {
                    mCurrentlySelectedSeat.clearSelection();
                    mCurrentlySelectedSeat = null;
                    animateShelfDown();
                }
            }
        });
    }

    private void populateSeatLayout() {
        for (int i = 1; i <= 10; i++) {
            createSeatLayoutRow(i);
        }
    }

    private void createSeatLayoutRow(int rowNumber) {
        View.OnClickListener onSeatClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v instanceof SeatView) {
                    SeatView seatView = (SeatView) v;
                    Seat seat = seatView.getSeat();
                    if (seat != null && seat.isAvailable()) {
                        if (seat.isAvailable()) {
                            mSelectButton.setVisibility(View.VISIBLE);
                        } else {
                            mSelectButton.setVisibility(View.INVISIBLE);
                        }
                        if (seat.getSeatType() == Seat.SeatType.PREFERRED) {
                            int seatColor = ContextCompat.getColor(getApplicationContext(), seat.getSeatColor());
                            mShelfSeatNumber.setTextColor(seatColor);
                            mShelfPrice.setTextColor(seatColor);
                            Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), seat.getSeatColor());
                            mShelfTopBar.setBackground(drawable);
                        }
                        if (seat.getRating() != null) {
                            mShelfRating.setText(seat.getRating());
                        }
                        if (seat.getPrice() != null) {
                            mShelfPrice.setText(seat.getPrice());
                        }
                        mShelfSeatType.setText(seat.getSeatTypeString());
                        mShelfFeatures.setText(seat.getFeatures());
                        mShelfSeatNumber.setText(getString(R.string.shelf_seat_number, seat.getSeatNumber()));
                        if (mCurrentlySelectedSeat != null) {
                            mCurrentlySelectedSeat.clearSelection();
                        }
                        if (mCurrentlySelectedSeat == seatView) {
                            mCurrentlySelectedSeat = null;
                            animateShelfDown();
                        } else {
                            seatView.setSelected();
                            mCurrentlySelectedSeat = seatView;
                            if (!isSeatShelfShowing) {
                                animateShelfUp();
                            }
                        }
                    }
                }
            }
        };

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Map<String, Seat> seatMap = buildSeatMapForRow(rowNumber);
        mSeatmapRowLinearLayout.addView(linearLayout, layoutParams);

        int margin = dpToPixels(4f);
        LinearLayout.LayoutParams seatLayoutParams = new LinearLayout.LayoutParams(0, 0, 1f);
        seatLayoutParams.setMargins(margin, margin, margin, margin);
        for (int i = 0; i < 7; i++) {
            if (i != 3) {
                String key = String.valueOf(rowNumber) + mapIndexToLetter(i);
                SeatView seatView = new SeatView(this, seatMap.get(key));
                seatView.setOnClickListener(onSeatClickListener);
                linearLayout.addView(seatView, seatLayoutParams);
            } else {
                SeatmateTextView textView = new SeatmateTextView(this);
                textView.setText(String.valueOf(rowNumber));
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f);
                linearLayout.addView(textView, seatLayoutParams);
            }
        }
//        SeatMapRowView rowView = new SeatMapRowView(this, buildSeatMapForRow(rowNumber), new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v instanceof SeatView) {
//                    SeatView seatView = (SeatView) v;
//                    if (mCurrentlySelectedSeat != null) {
//                        mCurrentlySelectedSeat.clearSelection();
//                    }
//                    if (mCurrentlySelectedSeat == seatView) {
//                        mCurrentlySelectedSeat = null;
//                        animateShelfDown();
//                    } else {
//                        seatView.setSelected();
//                        mCurrentlySelectedSeat = seatView;
//                        if (!isSeatShelfShowing) {
//                            animateShelfUp();
//                        }
//                    }
//                }
//            }
//        });
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        rowView.setLayoutParams(layoutParams);
//        rowView.setRowNumber(rowNumber);
//        mSeatmapRowLinearLayout.addView(rowView);
    }

    private void animateShelfDown() {
        mSeatmapShelf.animate().
                translationY(mSeatmapShelfHeight)
                .setDuration(300)
                .setInterpolator(mInterpolator)
                .start();
        isSeatShelfShowing = false;
    }

    private void animateShelfUp() {
        mSeatmapShelf.animate()
                .translationY(0)
                .setDuration(300)
                .setInterpolator(mInterpolator)
                .start();
        isSeatShelfShowing = true;
    }

    private Map<String, Seat> buildSeatMapForRow(int rowNumber) {
        Map<String, Seat> seatMap = new HashMap<>(6);
        for (int i = 0; i < 7; i++) {
            if (i != 3) {
                String seatNumber = String.valueOf(rowNumber) + mapIndexToLetter(i);
                Seat seat = new Seat(seatNumber);
                seatMap.put(seatNumber, seat);
            }
        }
        return seatMap;
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

    private int dpToPixels(float dps) {
        return (int) (dps * getResources().getDisplayMetrics().density);
    }
}
