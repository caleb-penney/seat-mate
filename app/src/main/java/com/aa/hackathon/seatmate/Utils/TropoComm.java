package com.aa.hackathon.seatmate.Utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 522121 on 4/16/2016.
 */
public class TropoComm
{
    private static final String urlPart1 = "https://api.tropo.com/1.0/sessions?action=create&token=7075755468486f7a41485448416b4745675755777a5162754d776f7642544669786a7343546d55777848704b&numberToDial=";
    private static final String urlPart2 = "&msg=Would%20you%20like%20to%20share%20your%20seat%20and%20name%20with%20a%20coworker%20on%20the%20plane?\n" + "\n";
    private static final String urlPart3 = "&msg=Darrin%20in%20seat%20A5%20is%20a%20coworker.\n" + "\n";

    public static void sendRequestToShare(String phoneNumber)
    {
        // Create a new HttpClient and Post Header
        OkHttpClient httpclient = new OkHttpClient();

        String url = urlPart1 + phoneNumber + urlPart2;

        try
        {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = httpclient.newCall(request).execute();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
        }
    }

    public static void sendShareInfo(String phoneNumber)
    {
        // Create a new HttpClient and Post Header
        OkHttpClient httpclient = new OkHttpClient();

        String url = urlPart1 + phoneNumber + urlPart3;

        try
        {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = httpclient.newCall(request).execute();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
        }
    }
}
