package com.services.sonata.food.e.foodie_e_food.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.services.sonata.food.e.foodie_e_food.Methods;
import com.services.sonata.food.e.foodie_e_food.R;
import com.services.sonata.food.e.foodie_e_food.models.User;
import com.services.sonata.food.e.foodie_e_food.variables.V;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnSignup;
    private LoginButton btnLoginFb;
    private CallbackManager mFacebookCallbackManager;

    private String USER_MAIL = ".user.email";
    private String USER_PASSWORD = ".user.password";
    private String USER_NAME = ".user.name";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLoginFb = (LoginButton) findViewById(R.id.btn_login_fb);
        btnSignup = (Button) findViewById(R.id.btn_signup);

        //Facebook Login
        FacebookSdk.sdkInitialize(getApplicationContext());
        mFacebookCallbackManager = CallbackManager.Factory.create();

        btnLoginFb.setReadPermissions(Arrays.asList("public_profile", "user_friends", "email", "user_birthday"));
        btnLoginFb.registerCallback(mFacebookCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //App Code
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        String name = "";
                        String email = "";
                        String uriPicture = "";

                        if (Methods.isNotNull(object)) {
                            try {
                                name = object.getString("name");
                                email = object.getString("email");
                                if (Methods.isNotNull(object.getString("picture"))) {
                                    JSONObject imagen = new JSONObject(object.getString("picture"));
                                    JSONObject imagen2 = new JSONObject(imagen.getString("data"));
                                    uriPicture = imagen2.getString("url");
                                }
                                Log.i("name", name);
                                Log.i("email", email);
                                Log.i("uriPicture", uriPicture);

                                SharedPreferences preferences = getSharedPreferences(V.APP_PACKAGE, Context.MODE_PRIVATE);
                                preferences.edit().putString(V.APP_PACKAGE + USER_MAIL, email).apply();
                                preferences.edit().putString(V.APP_PACKAGE + USER_NAME, name).apply();

                                goToMainActivity(email, name, email, uriPicture);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,link,gender,birthday,email,picture");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.d(LoginActivity.class.getCanonicalName(), error.getMessage());
            }
        });
        initListeners();
    }

    private void initListeners() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
    }

    public void goToMainActivity() {
        V.user = new User();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    public void goToMainActivity(String email, String name, String phone, String uriPicture) {
        V.user = new User(email, name, phone, uriPicture);
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    public void hasLogin() {
        boolean hasSession = false;
        SharedPreferences preferences = getSharedPreferences(V.APP_PACKAGE, Context.MODE_PRIVATE);
        if (preferences.getString(V.APP_PACKAGE + USER_MAIL, "") == "" && preferences.getString(V.APP_PACKAGE + USER_PASSWORD, "") == "") {
            hasSession = true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
