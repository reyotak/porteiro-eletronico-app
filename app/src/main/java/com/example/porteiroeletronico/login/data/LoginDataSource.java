package com.example.porteiroeletronico.login.data;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.example.porteiroeletronico.login.api.LoginDataApi;
import com.example.porteiroeletronico.login.api.LoginRequest;
import com.example.porteiroeletronico.login.api.LoginResponse;
import com.example.porteiroeletronico.login.model.LoggedInUser;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private String mUserName;
    private boolean success = false;

    public Result<LoggedInUser> login(String username, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.14:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginDataApi loginDataApi = retrofit.create(LoginDataApi.class);
        LoginRequest loginRequest = new LoginRequest(username, password);
        Call<LoginResponse> call = loginDataApi.login(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    mUserName = loginResponse.getUsername();
                    success = true;
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // TODO: Checking why it's failling
                success = true;
            }
        });
        LoggedInUser user = new LoggedInUser(username, username);
        Log.d(TAG, "login: RENAN");
        return new Result.Success<>(user);
    }

    public void logout() {
        // TODO: revoke authentication
    }
}