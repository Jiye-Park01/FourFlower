package com.example.ff_sdci;

import com.example.ff_sdci.DB.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiService {

//    @GET("api/users")
//    Call<List<User>> getAllUsers();

    @POST("api/users/login")
    Call<String> login(@Body User user);

}
