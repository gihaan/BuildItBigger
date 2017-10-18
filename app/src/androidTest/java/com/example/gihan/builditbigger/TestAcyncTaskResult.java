package com.example.gihan.builditbigger;


import android.test.AndroidTestCase;


/**
 * Created by Gihan on 10/18/2017.
 */


public class TestAcyncTaskResult extends AndroidTestCase {


    public void test() {

        String value = null;
        AcyncTaskJoke acyncTaskJoke = new AcyncTaskJoke(getContext());
        acyncTaskJoke.execute();
        try {
            value = acyncTaskJoke.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(value);
    }


}