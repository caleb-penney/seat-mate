package com.aa.hackathon.seatmate.Utils;

import android.os.AsyncTask;

/**
 * Created by 522121 on 4/16/2016.
 */
public class NetworkAsyncTaskRequestToShare extends AsyncTask<String, Void, Boolean>
{

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(String... phoneNumber)
    {
        TropoComm.sendRequestToShare(phoneNumber[0]);

        return false;
    }

    protected void onPostExecute(Boolean result)
    {

    }
}