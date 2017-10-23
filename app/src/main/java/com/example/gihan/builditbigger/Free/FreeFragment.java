package com.example.gihan.builditbigger.Free;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gihan.builditbigger.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class FreeFragment extends Fragment {

    private AdView adView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_free, container, false);
         adView = (AdView) v.findViewById(R.id.adViewFree);


        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);


        return v;
    }

}
