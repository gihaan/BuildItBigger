package com.example.gihan.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.InitializeJoke;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainFragment extends Fragment {




    private InitializeJoke initializeJokes;

    private AdView adView;
    private Button tellJoke;
    private ProgressDialog mProgress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        initializeJokes =new InitializeJoke();
        tellJoke = (Button) v.findViewById(R.id.tell_joke);
        adView = (AdView) v.findViewById(R.id.adView);

        mProgress=new ProgressDialog(getContext());
        mProgress.setMessage("Wait");

        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");

        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);

        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.show();
                AcyncTaskJoke taskJoke=new AcyncTaskJoke(getContext());
                taskJoke.execute(new Pair<Context, String>(getContext(),""));
              //  mProgress.dismiss();
            }
        });


        return v;    }


    @Override
    public void onResume() {
        super.onResume();
        mProgress.dismiss();

    }
}
