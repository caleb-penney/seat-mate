package com.aa.hackathon.seatmate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.Spinner;

/**
 * Created by caleb on 4/16/16.
 */
public class SeatmatePreferenceActivity extends AppCompatActivity {

    private CheckBox mSelfPreferenceTalk;
    private CheckBox mSelfPreferenceSleep;
    private CheckBox mSelfPreferenceRead;
    private CheckBox mSelfPreferenceWork;
    private CheckBox mSeatmatePreferenceTalk;
    private CheckBox mSeatmatePreferenceSleep;
    private CheckBox mSeatmatePreferenceWork;
    private CheckBox mSeatmatePreferenceKids;
    private CheckBox mSeatmatePreferencePets;
    private Spinner mOptionalPrefWorkIndustry;
    private Spinner mOptionalPrefCompany;
    private Spinner mOptionalPrefInterests;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_seatmate_preferences);
        setViewInstances();
    }

    private void setViewInstances() {
        mSelfPreferenceTalk = (CheckBox) findViewById(R.id.selfPreferenceTalk);
        mSelfPreferenceSleep = (CheckBox) findViewById(R.id.selfPreferenceSleep);
        mSelfPreferenceRead = (CheckBox) findViewById(R.id.selfPreferenceRead);
        mSelfPreferenceWork = (CheckBox) findViewById(R.id.selfPreferenceWork);
        mSeatmatePreferenceTalk = (CheckBox) findViewById(R.id.seatmatePreferenceTalk);
        mSeatmatePreferenceSleep = (CheckBox) findViewById(R.id.seatmatePreferenceSleep);
        mSeatmatePreferenceWork = (CheckBox) findViewById(R.id.seatmatePreferenceWork);
        mSeatmatePreferencePets = (CheckBox) findViewById(R.id.seatmatePreferencePets);
        mOptionalPrefWorkIndustry = (Spinner) findViewById(R.id.optionalPrefWorkIndustry);
        mOptionalPrefCompany = (Spinner) findViewById(R.id.optionalPrefCompany);
        mOptionalPrefInterests = (Spinner) findViewById(R.id.optionalPrefInterests);
    }
}
