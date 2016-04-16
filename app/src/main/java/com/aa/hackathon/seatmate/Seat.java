package com.aa.hackathon.seatmate;

import android.support.annotation.ColorRes;
import android.util.Log;

/**
 * Created by caleb on 4/16/16.
 */
public class Seat {

    private boolean isMatchedSeat = false;
    private String mSeatTypeString = "Standard";
    private String mRating;
    private String mFeatures = "";
    private String mPrice;
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
            mFeatures = "";
            return SeatType.MAIN_CABIN_EXTRA;
        } else if (seatNumber.contains("4") || seatNumber.contains("5")) {
            Log.d("Seat", "Preferred type set");
            mSeatColor = R.color.americanPreferredGreen;
            mFeatures = "Standard legroom\nFavorable Location";
            mSeatTypeString = "Preferred";
            return SeatType.PREFERRED;
        } else {
            Log.d("Seat", "Standard type set");
            mSeatColor = R.color.americanBlueDark;
            mFeatures = "";
            return SeatType.STANDARD;
        }
    }

    private boolean determineAvailability(String seatNumber) {
        switch (seatNumber) {
            case "4B":
            case "5E":
            case "7B":
            case "5B":
                if ("4B".equals(seatNumber)) {
                    mPrice = "$12";
                    mRating = "3 out of 5";
                    isMatchedSeat = true;
                } else if ("5E".equals(seatNumber)) {
                    mPrice = "$24";
                    mRating = "5 out of 5";
                    isMatchedSeat = true;
                }
                return true;
            default:
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

    public String getRating() {
        return mRating;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getFeatures() {
        return mFeatures;
    }

    public String getSeatTypeString() {
        return mSeatTypeString;
    }

    public boolean isMatchedSeat() {
        return isMatchedSeat;
    }
}
