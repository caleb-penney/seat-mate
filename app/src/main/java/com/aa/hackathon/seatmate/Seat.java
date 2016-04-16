package com.aa.hackathon.seatmate;

import android.util.Log;

/**
 * Created by caleb on 4/16/16.
 */
public class Seat {
    private String mSeatNumber;

    public Seat(String seatNumber) {
        mSeatNumber = seatNumber;
        Log.d("Seat", "Seat Number: " + seatNumber);
    }

    public String getSeatNumber() {
        return mSeatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        mSeatNumber = seatNumber;
    }
}
