package com.example.arial.cargomanger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class LoginActivity extends AppCompatActivity implements View.OnTouchListener {

    private ViewFlipper vFlipper;
    private float xAtDown;
    private float xAtUp;
    int i = 0;
    private Button btnResist;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        setUpUI();
        Intent intent = new Intent(LoginActivity.this, Resist.class);
    }

    private void setUpUI() {
        vFlipper = (ViewFlipper) findViewById(R.id.slide);
        vFlipper.setOnTouchListener(this);
        btnResist = (Button) findViewById(R.id.btnRegist);
        btnResist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Resist.class);
                startActivity(intent);
            }
        });
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Login.class);
                startActivity(intent);

            }
        });
    }

    private void nextFlipper() {

        if (i < 2) {
            vFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_left_in));
            vFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_right_out));
            vFlipper.showNext();
            i++;
        } else
            vFlipper.startAnimation(AnimationUtils.loadAnimation(this, R.anim.crash));
    }

    private void prevFlipper() {
        if (i > 0) {
            vFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_right_in));
            vFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_left_out));

            vFlipper.showPrevious();
            i--;
        } else
            vFlipper.startAnimation(AnimationUtils.loadAnimation(this, R.anim.crash));
    }

    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, AdWebView.class);
        startActivity(intent);
        finish();

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            xAtDown = event.getX(); // 터치 시작지점 x좌표 저장

        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            xAtUp = event.getX(); // 터치 끝난지점 x좌표 저장

            if (xAtUp < xAtDown) {
                nextFlipper();
            } else if (xAtUp > xAtDown) {
                prevFlipper();
            }
        }
        return true;
    }
}
