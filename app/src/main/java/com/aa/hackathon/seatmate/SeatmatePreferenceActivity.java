package com.aa.hackathon.seatmate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

/**
 * Created by caleb on 4/16/16.
 */
public class SeatmatePreferenceActivity extends AppCompatActivity {

    private CheckBox mSelfPreferenceTalk;
    private CheckBox mSelfPreferenceSleep;
    private CheckBox mSelfPreferenceRead;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_seatmate_preferences);
    }
}
