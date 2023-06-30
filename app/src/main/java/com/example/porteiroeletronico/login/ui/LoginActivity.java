package com.example.porteiroeletronico.login.ui;

import static android.content.ContentValues.TAG;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.porteiroeletronico.login.api.LoginDataApi;
import com.example.porteiroeletronico.login.api.LoginRequest;
import com.example.porteiroeletronico.login.api.LoginResponse;
import com.example.porteiroeletronico.main.MainActivity;
import com.example.porteiroeletronico.R;
import com.example.porteiroeletronico.databinding.ActivityLoginBinding;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    private boolean failed = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(true);
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                setResult(Activity.RESULT_OK);
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);

                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.65.100:8080")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                LoginDataApi loginDataApi = retrofit.create(LoginDataApi.class);
                LoginRequest loginRequest = new LoginRequest(username, password);
                Call<LoginResponse> call = loginDataApi.login(loginRequest);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        loadingProgressBar.setVisibility(View.INVISIBLE);
                        if (response.isSuccessful()) {
                            LoginResponse loginResponse = response.body();
                            updateUiWithUser(username);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        showLoginFailed();
                    }
                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        loadingProgressBar.setVisibility(View.INVISIBLE);
                        failed = true;
                    }
                });
                if (failed) showLoginFailed();
            }
        });
    }

    private void updateUiWithUser(String username) {
        String welcome = getString(R.string.welcome) + " " + username;
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed() {
        String failed = "Dados inválidos";
        Toast.makeText(getApplicationContext(), failed, Toast.LENGTH_LONG).show();
    }
}