package com.example.pertemuan9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    EditText txtLat, txtLng;
    Button btnSet;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map_fragment);

        mapFragment.getMapAsync(googleMap ->  {
           map = googleMap;
        });

        btnSet.setOnClickListener(v -> {
            String lat_ = txtLat.getText().toString();
            String lng_ = txtLng.getText().toString();

            try {
                double lat = Double.parseDouble(lat_);
                double lng = Double.parseDouble(lng_);

                updatePosition(new LatLng(lat, lng));
            } catch (Exception e) {

            }

        });

    }

    private void updatePosition(LatLng LatLng) {
        MarkerOptions marker = new MarkerOptions();
        marker.title("Here");
        marker.position(LatLng);
        map.addMarker(marker);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng, 15));
    }

    private void initialize() {
        txtLat = findViewById(R.id.txt_lat);
        txtLng = findViewById(R.id.txt_lng);
        btnSet = findViewById(R.id.btn_set);
    }
}