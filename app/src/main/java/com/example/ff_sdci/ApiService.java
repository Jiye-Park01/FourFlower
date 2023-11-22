package com.example.ff_sdci;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {

//    @GET("api/users")
//    Call<List<User>> getAllUsers();

    @POST("api/users/login")
    Call<String> login(@Body User user);

}
