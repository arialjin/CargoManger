package com.example.arial.cargomanger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by arial on 2016-05-01.
 */
public class Select extends AppCompatActivity{
    private ImageButton btnClient;
    private ImageButton btnDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        setUpUI();

    }

    private void setUpUI() {
        btnClient = (ImageButton)findViewById(R.id.btnClient);
        btnClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select.this, ClientMain.class);
                startActivity(intent);
            }
        });
        btnDriver = (ImageButton)findViewById(R.id.btnDriver);
        btnDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Select.this, DriverMain.class);
                startActivity(intent);
                finishActivity(1);
                finishActivity(2);
                finishActivity(3);
            }
        });
    }
}
