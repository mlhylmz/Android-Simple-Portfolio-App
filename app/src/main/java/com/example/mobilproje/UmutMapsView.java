package com.example.mobilproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mobilproje.databinding.ActivityUmutMapsViewBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class UmutMapsView extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private ActivityUmutMapsViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUmutMapsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps_u);
        mapFragment.getMapAsync((OnMapReadyCallback) this);
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

        // Add a marker in Sydney and move the camera
        LatLng turgutlu = new LatLng(38.50627460627705, 27.705920841908696);
        mMap.addMarker(new MarkerOptions().position(turgutlu).title("Marker in Turgutlu"));
        float zoomLevel = 15.0f;
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(turgutlu));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(turgutlu, zoomLevel));
    }
}