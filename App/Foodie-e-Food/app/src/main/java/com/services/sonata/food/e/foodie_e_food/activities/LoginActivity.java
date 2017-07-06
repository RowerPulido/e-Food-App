package com.services.sonata.food.e.foodie_e_food.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.services.sonata.food.e.foodie_e_food.R;
import com.services.sonata.food.e.foodie_e_food.models.User;
import com.services.sonata.food.e.foodie_e_food.variables.V;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        initListeners();
    }

    private void initListeners() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                V.user = new User();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }
}
