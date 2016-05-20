package com.example.arial.cargomanger;

import android.app.MediaRouteButton;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by arial on 2016-05-01.
 */
public class AdWebView extends AppCompatActivity{
    private MediaRouteButton prgLoading;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ad_view);
        setUpUI();
        Toast.makeText(this, "한번 더 누르면 어플리케이션이 종료됩니다.", Toast.LENGTH_SHORT).show();
    }

    private void setUpUI() {
    webview =(WebView)findViewById(R.id.wbAd);
        webview.setWebViewClient(new WebViewClient());
        WebSettings set = webview.getSettings();
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(false);
        webview.loadUrl("http://www.naver.com");
    }
    class WebClient extends WebViewClient{
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
    public void onBackPressed() {
        finish();
    }
}
