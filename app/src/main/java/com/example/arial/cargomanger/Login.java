package com.example.arial.cargomanger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by arial on 2016-05-01.
 */
public class Login extends AppCompatActivity{

    private Button btnLogAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpUI();
    }

    private void setUpUI() {
        btnLogAdmin = (Button)findViewById(R.id.btnLogAdmin);
        btnLogAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Select.class);
                startActivity(intent);

            }
        });
    }
}
