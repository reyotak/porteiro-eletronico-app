package com.example.porteiroeletronico.login.data;

import com.example.porteiroeletronico.login.model.LoggedInUser;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
            LoggedInUser user = new LoggedInUser(username, username);
            return new Result.Success<>(user);
    }

    public void logout() {
        // TODO: revoke authentication
    }
}