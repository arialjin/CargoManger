package com.example.arial.cargomanger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapView;


/**
 * Created by arial on 2016-05-01.
 */
public class ClientMain extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_main);
        setUpUI();
    }

    private void setUpUI() {
        MapView mapView = new MapView(this);
        mapView.setDaumMapApiKey("af1e521561ca338dcd3f80d8fa06910c");

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
    }

}

