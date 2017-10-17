package com.example.jokegradel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokes extends AppCompatActivity {

    private TextView mDisplayJokes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jokes);



        mDisplayJokes=(TextView)findViewById(R.id.tv_display_joke);
        String joke=getIntent().getExtras().getString("joke");

        mDisplayJokes.setText(joke);
    }
}
