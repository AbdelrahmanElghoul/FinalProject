package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.test.espresso.idling.CountingIdlingResource;

import com.example.displayingjokeactivity.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    static CountingIdlingResource idlingResource=new CountingIdlingResource("FinalProject");

    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        idlingResource.increment();
    }

    @Override
    protected String doInBackground(Context... params) {
            context=params[0];

        try {
            return ReadGCE();
        } catch (IOException e) {
           return e.getMessage();
        }
    }

    public String ReadGCE() throws IOException {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(
                            abstractGoogleClientRequest -> abstractGoogleClientRequest.setDisableGZipContent(true));
            // end options for devappserver

            myApiService = builder.build();
        }
            return myApiService.getJoke().execute().getJoke();
    }

    @Override
    protected void onPostExecute(String result) {
        idlingResource.decrement();
        Intent i=new Intent(context, JokeActivity.class);
        i.putExtra(context.getString(R.string.JOKES_KEY),result);
        context.startActivity(i);
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();

    }
}