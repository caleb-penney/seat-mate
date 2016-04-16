package com.aa.hackathon.seatmate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aa.hackathon.seatmate.view.SeatMapRowView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mSeatmapRowLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mSeatmapRowLinearLayout = (LinearLayout) findViewById(R.id.mainSeatmapRowLinearLayout);
        if (mSeatmapRowLinearLayout != null) {
            mSeatmapRowLinearLayout.removeAllViews();
        }
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

    private void populateSeatLayout() {
        for (int i = 1; i <= 20; i++) {
            createSeatLayoutRow(i);
        }
    }

    private void createSeatLayoutRow(int rowNumber) {
        SeatMapRowView rowView = new SeatMapRowView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rowView.setLayoutParams(layoutParams);
        rowView.setRowNumber(rowNumber);
        mSeatmapRowLinearLayout.addView(rowView);
    }
}
