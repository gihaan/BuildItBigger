package com.example.Gihan.myapplication.backend;

import com.example.InitializeJoke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private InitializeJoke initializeJoke;


    public  MyBean(){
    initializeJoke=new InitializeJoke();
    }
    public String getData() {
        return initializeJoke.getJokes();
    }

}