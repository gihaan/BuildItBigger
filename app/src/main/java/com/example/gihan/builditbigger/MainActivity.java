package com.example.gihan.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager().beginTransaction().add(R.id.main_activity, new com.example.gihan.builditbigger.MainFragment()).commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.refresh) {
            tellJoke();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unchecked")
    public void tellJoke() {
        new com.example.gihan.builditbigger.AcyncTaskJoke(this).execute();

    }
}
