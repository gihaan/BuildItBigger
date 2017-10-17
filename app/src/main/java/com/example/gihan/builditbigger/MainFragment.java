package com.example.gihan.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.InitializeJoke;
import com.example.jokegradel.ShowJokes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainFragment extends Fragment {



    private InitializeJoke initializeJokes;

    private AdView adView;
    private Button tellJoke;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        initializeJokes =new InitializeJoke();
        tellJoke = (Button) v.findViewById(R.id.tell_joke);
        adView = (AdView) v.findViewById(R.id.adView);
        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");

        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);


        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    Toast.makeText(getContext(),initializeJokes.getJokes(),Toast.LENGTH_SHORT).show();
                // tellJoke.setText(initializeJokes.getJokes());

                Intent i =new Intent(getContext(), ShowJokes.class);
                i.putExtra("joke",initializeJokes.getJokes());
                startActivity(i);

            }
        });

        return v;    }


}
