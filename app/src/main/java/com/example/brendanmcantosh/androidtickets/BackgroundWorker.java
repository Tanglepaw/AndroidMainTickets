package com.example.brendanmcantosh.androidtickets;


import android.content.Context;
import android.icu.util.Output;
import android.os.AsyncTask;
import android.provider.Settings;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;


public class BackgroundWorker extends AsyncTask<String,Void,String> {

    private TextView textView;
    Context context;

    BackgroundWorker (Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String type = params[0];
        String login_url = "https://tickats.live/login.php";
        String TicketStart_URL = "https://tickats.live/DisplayDataTickets.php";


        if (type.equals("login")) {

            try {
                String user_name = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                outputStream.close();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("TicketStart")){
            try{
                String fwid = params[1];
                URL url = new URL(TicketStart_URL);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStream outputStream = conn.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8" ));
                String post_data = URLEncoder.encode("fwid", "UTF-8") + "=" + URLEncoder.encode(fwid, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) !=null ){
                    result += line;

                }

                JSONObject JO = new JSONObject(result);
                JSONArray jTickets = JO.getJSONArray("Tickets");// Array name from php file

                for(int i =0; i<jTickets.length(); i++){
                    JSONObject t = jTickets.getJSONObject(i);
                 // Pulls data from the URL and puts it into a string for later insertion
                    String Tid  = t.getString("TicketID");
                    String wName  = t.getString("WorksiteName");
                    String Prior  = t.getString("Priority");
                // Adds values from the JSON array into the relative layout
                    Tickets.mTicketID.add(Tid);
                    Tickets.mWorksite.add(wName);
                    Tickets.mPriority.add(Prior);
                }

                bufferedReader.close();
                inputStream.close();
                outputStream.close();
                return result;

            }
            catch(MalformedURLException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return null;
    }



}
