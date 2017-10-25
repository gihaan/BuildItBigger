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



public class MainFragment extends Fragment {


    private InitializeJoke initializeJokes;

    private Button tellJoke;
    private ProgressDialog mProgress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);


        initializeJokes = new InitializeJoke();
        tellJoke = (Button) v.findViewById(R.id.tell_joke);

        mProgress = new ProgressDialog(getContext());
        mProgress.setMessage("Wait");


        tellJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.show();
                AcyncTaskJoke taskJoke = new AcyncTaskJoke(getContext());
                taskJoke.execute(new Pair<Context, String>(getContext(), ""));
            }
        });


        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        mProgress.dismiss();

    }
}
