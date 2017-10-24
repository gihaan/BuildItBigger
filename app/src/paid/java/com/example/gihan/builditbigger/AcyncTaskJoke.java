package com.example.gihan.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.example.gihan.builditbigger.R;
import com.example.gihan.myapplication.backend.myApi.MyApi;
import com.example.gihan.myapplication.backend.myApi.model.MyBean;
import com.example.jokegradel.ShowJokes;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


/**
 * Created by Gihan on 10/17/2017.
 */

public class AcyncTaskJoke extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService = null;
    private Context mCtx;
    private InterstitialAd mInterstitialAd;
    String Joke;


    public AcyncTaskJoke(Context mContexts) {
        this.mCtx = mContexts;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbeigger.appspot.com/_ah/api/");

            myApiService = builder.build();
        }


        try {

            return myApiService.sayHi(new MyBean()).execute().getJoke();

        } catch (IOException e) {

            String ff=e.toString();
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Joke = s;


        AdRequest ar = new AdRequest
                .Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        // Setting the interstitial ad
        mInterstitialAd = new InterstitialAd(mCtx);
        mInterstitialAd.setAdUnitId(mCtx.getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);

                //    mProgress.dismiss();
                startJokeDisplayActivity();
            }

            @Override
            public void onAdClosed() {
                startJokeDisplayActivity();
            }
        });
        AdRequest arr = new AdRequest
                .Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice(mCtx.getString(R.string.device_id))
                .build();
        mInterstitialAd.loadAd(arr);
    }

    private void startJokeDisplayActivity() {
        Intent intent = new Intent(mCtx, ShowJokes.class);
        intent.putExtra("joke", Joke);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mCtx.startActivity(intent);

    }


}
