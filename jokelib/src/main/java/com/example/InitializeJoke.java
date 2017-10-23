package com.example;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Gihan on 10/16/2017.
 */

public class InitializeJoke {


    private String jokes[];

    public InitializeJoke() {

        jokes=new String[7];

        jokes[0] = "first jpke in my applications";
        jokes[1] = "secod jpke in my applications";
        jokes[2] = "third jpke in my applications";
        jokes[3] = "forth jpke in my applications";
        jokes[4] = "fifth jpke in my applications";
        jokes[5] = "sixth jpke in my applications";
        jokes[6] = "seven jpke in my applications";

    }

    public String getJokes() {
        return jokes[random()];
    }



    public int random() {

        int randomNum;
        int minimum = 0;
        int maximum = 5;
        randomNum = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);

        return randomNum;

    }
}
