package com.example.modul5;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng rumah = new LatLng(0.151792, 117.479894);
        mMap.addMarker(new MarkerOptions().position(rumah).title("Rumah"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rumah));

        LatLng restoran = new LatLng(0.154884, 117.478228);
        mMap.addMarker(new MarkerOptions().position(restoran).title("Restoran Pujasera Tahap 6"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(restoran));

        mMap.addPolyline(new PolylineOptions().add(restoran,
                new LatLng(0.154884, 117.478228),//belokan1
                new LatLng(0.154739, 117.478207),//belokan1
                new LatLng(0.152197, 117.480353),//belokan1
                rumah
                ).color(Color.GREEN)
        );
    }

}
