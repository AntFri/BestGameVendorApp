package com.antoniofrische.bestgamevendorapp.rest;

import com.antoniofrische.bestgamevendorapp.interfa.IAPIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static IAPIService instance;
    public static final int PORT = 21000;
    public static final String IP_CONNECTION = "192.168.20.204";
    private static final String BASE_URL = "http://"+ IP_CONNECTION + ":" + PORT + "/";

    /* Lo hacemos privado para evitar que se puedan crear instancias de esta forma */
    private RestClient() {

    }

    public static synchronized IAPIService getInstance() {
        if(instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = retrofit.create(IAPIService.class);
        }
        return instance;
    }
}
