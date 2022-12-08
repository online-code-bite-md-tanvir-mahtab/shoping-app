package com.example.mytask;

import com.example.mytask.util.ProductEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/products")
    Call<List<ProductEntity>> getAllProducts();
}
