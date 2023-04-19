package com.antoniofrische.bestgamevendorapp.interfa;


import com.antoniofrische.bestgamevendorapp.models.ProductosEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IAPIService {
    @GET("/app/productAll")
    Call<List<ProductosEntity>> getProducts();

    @GET("/app/product/{id}")
    Call<List<ProductosEntity>> getProducts(@Path("id") long id);
}
