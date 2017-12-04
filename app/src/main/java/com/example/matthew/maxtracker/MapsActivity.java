package com.example.matthew.maxtracker;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MapsActivity extends FragmentActivity
        implements OnMyLocationButtonClickListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int PERMISSION_ACCESS_FINE_LOCATION = 1;
    private GoogleApiClient googleApiClient;

    private GoogleMap mMap;
    MaxStops maxRoute = new MaxStops(this); //Object for Max map

    int direction = 0; //0 = North, 1 = South


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION },
                    PERMISSION_ACCESS_FINE_LOCATION);
        }

        setup();
    }

    public void changeDirection(View view) {
        TextView directionText= findViewById(R.id.toDirection);
        TextView lastText= findViewById(R.id.last);
        TextView minRemaining= findViewById(R.id.minRemaining);
        TextView curStop= findViewById(R.id.CurrentStop);

        if (direction == 0)
        {direction = 1;}

        else{direction = 0;}

        maxRoute.updateStopLoc(curStop);
        if(maxRoute.isInOperation() == true){
            maxRoute.updateTimeRemaining(minRemaining,directionText, lastText, direction);
        }
        else{
            //Ntime = findViewById(R.id.NorthMin);
            //Stime = findViewById(R.id.SouthMin);
            //Ntime.setText("No Bus On Route");
            //Stime.setText("No Bus On Route");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();

        maxRoute.addMapMarkers(mMap);   //Places markers for stops
        maxRoute.addRouteLine(mMap);    //Draw route linea
        maxRoute.showRealTime(mMap);

        //(39.052397, -94.586374) ,12.25f) for full view
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(maxRoute.getLatitude(), maxRoute.getLongitude()), 14.25f));
    }
  
    @Override
    public void onConnected(Bundle bundle) {
        Log.i(MapsActivity.class.getSimpleName(), "Connected to Google Play Services!");

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

            double lat = lastLocation.getLatitude(), lon = lastLocation.getLongitude();
        }
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i(MapsActivity.class.getSimpleName(), "Can't connect to Google Play Services!");
    }

    @Override
    public boolean onMyLocationButtonClick() {
        //Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).

        setup();
        return false;
    }

    public void onClickAbout(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);  //Shows about activity
    }

    public void setup(){
        TextView directionText= findViewById(R.id.toDirection);
        TextView lastText= findViewById(R.id.last);
        TextView minRemaining= findViewById(R.id.minRemaining);
        TextView curStop= findViewById(R.id.CurrentStop);

        maxRoute.updateStopLoc(curStop);
        if(maxRoute.isInOperation() == true){
            maxRoute.updateTimeRemaining(minRemaining, directionText, lastText, direction);
        }
        else{
            curStop.setText("No Busses Running");
            minRemaining.setText(" ");
            directionText.setText(" ");
        }
    }
}