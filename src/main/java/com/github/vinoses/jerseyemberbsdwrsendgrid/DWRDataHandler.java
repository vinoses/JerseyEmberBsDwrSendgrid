package com.github.vinoses.jerseyemberbsdwrsendgrid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class DWRDataHandler {

    //private OutputStream output;

    public DWRDataHandler(){}

    private Object getTransactions(){
        Gson gson = new Gson();
        try {
            Object object = gson.fromJson(new FileReader("C:\\projects\\JerseyEmberBsDwrSendgrid\\src\\main\\webapp\\WEB-INF\\transactions.json"), Object.class);
            return object;
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
        return null;
    }

    public String jsonPrettyString(){
        Object json = getTransactions();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);

    }

    public String jsonString(){
        Object json = getTransactions();
        Gson gson = new Gson();
        return gson.toJson(json);

    }
}
