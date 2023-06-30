package com.example.porteiroeletronico.login.api;

import retrofit2.Call;
import retrofit2.http.*;

public interface LoginDataApi {
    @POST("auth/signup")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}