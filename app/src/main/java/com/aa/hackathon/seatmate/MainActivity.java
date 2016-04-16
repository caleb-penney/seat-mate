package com.aa.hackathon.seatmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aa.hackathon.seatmate.view.SeatMapRowView;
import com.aa.hackathon.seatmate.view.SeatView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1111;

    private LinearLayout mSeatmapRowLinearLayout;
    private CheckBox mShowPreferenceCheckbox;
    private TextView mEditPreferenceTextView;

    private SeatView mCurrentlySelectedSeat;

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
        mSeatmapRowLinearLayout = (LinearLayout) findViewById(R.id.mainSeatmapRowLinearLayout);
        mShowPreferenceCheckbox = (CheckBox) findViewById(R.id.preferenceCheckbox);
        mEditPreferenceTextView = (TextView) findViewById(R.id.preferenceEdit);
    }

    private void setListeners() {
        mEditPreferenceTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeatmatePreferenceActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    private void populateSeatLayout() {
        for (int i = 1; i <= 10; i++) {
            createSeatLayoutRow(i);
        }
    }

    private void createSeatLayoutRow(int rowNumber) {
        SeatMapRowView rowView = new SeatMapRowView(this, buildSeatMapForRow(rowNumber), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "onSeatClick()");
                if (v instanceof SeatView) {
                    Log.d("MainActivity", "onSeatClick(): instance of SeatView");
                    SeatView seatView = (SeatView) v;
                    if (mCurrentlySelectedSeat != null) {
                        Log.d("MainActivity", "onSeatClick(): mCurrentlySelectedSeat is not null");
                        mCurrentlySelectedSeat.clearSelection();
                    }
                    Log.d("MainActivity", "onSeatClick(): setSelectedSeat");
                    seatView.setSelected();
                    mCurrentlySelectedSeat = seatView;
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rowView.setLayoutParams(layoutParams);
        rowView.setRowNumber(rowNumber);
        mSeatmapRowLinearLayout.addView(rowView);
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
}
