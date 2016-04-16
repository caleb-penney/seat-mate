package com.aa.hackathon.seatmate;

import android.support.annotation.ColorRes;
import android.util.Log;

/**
 * Created by caleb on 4/16/16.
 */
public class Seat {

    private String mSeatNumber;
    private SeatType mSeatType;
    @ColorRes
    private int mSeatColor = R.color.americanStandardBlue;
    private boolean mAvailable;
    public enum SeatType {
        STANDARD, PREFERRED, MAIN_CABIN_EXTRA
    }

    public Seat(String seatNumber) {
        mSeatNumber = seatNumber;
        Log.d("Seat", "Seat Number: " + seatNumber);
        mSeatType = determineTypeForSeatNumber(seatNumber);
        mAvailable = determineAvailability(seatNumber);
    }

    public String getSeatNumber() {
        return mSeatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        mSeatNumber = seatNumber;
    }

    private SeatType determineTypeForSeatNumber(String seatNumber) {
        if (!seatNumber.contains("10") && seatNumber.contains("1") || seatNumber.contains("2")) {
            Log.d("Seat", "MCE type set");
            mSeatColor = R.color.americanMceOrange;
            return SeatType.MAIN_CABIN_EXTRA;
        } else if (seatNumber.contains("3")) {
            Log.d("Seat", "Preferred type set");
            mSeatColor = R.color.americanPreferredGreen;
            return SeatType.PREFERRED;
        } else {
            Log.d("Seat", "Standard type set");
            mSeatColor = R.color.americanStandardBlue;
            return SeatType.STANDARD;
        }
    }

    private boolean determineAvailability(String seatNumber) {
        if ("B4".equals(seatNumber)) {
            return  true;
        } else if ("E5".equals(seatNumber)) {
            return true;
        } else {
            return false;
        }
    }

    public @ColorRes int getSeatColor() {
        return mSeatColor;
    }

    public SeatType getSeatType() {
        return mSeatType;
    }

    public boolean isAvailable() {
        return mAvailable;
    }
}
