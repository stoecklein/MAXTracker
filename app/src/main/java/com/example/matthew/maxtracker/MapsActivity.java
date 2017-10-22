package com.example.matthew.maxtracker;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;


import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;


public class MapsActivity extends FragmentActivity
        implements OnMyLocationButtonClickListener,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int PERMISSION_ACCESS_FINE_LOCATION = 1;
    private GoogleApiClient googleApiClient;
    private GoogleMap mMap;
    MaxStops stopsObj = new MaxStops(); //Object for Max map


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

        updateStopLoc();
        if(ifBusOper() == true){
            updateTimeRemaining();
        }
        else{
            TextView Ntime= findViewById(R.id.NorthMin);
            TextView Stime= findViewById(R.id.SouthMin);
            Ntime.setText("No Bus On Route");
            Stime.setText("No Bus On Route");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMyLocationButtonClickListener(this);
        //mMap.setOnMyLocationClickListener(this);
        enableMyLocation();

        stopsObj.addMapMarkers(mMap);   //Places markers for stops
        stopsObj.addRouteLine(mMap);    //Draw route line


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.052397, -94.586374) , 12.25f) );

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
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    public void updateStopLoc(){

        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

            Stop tempObj = stopsObj.ClosestStop(latitude);
            TextView curLoc= findViewById(R.id.CurrentStop);
            curLoc.setText(tempObj.getName());
    }

    public void updateTimeRemaining(){
        TextView Ntime= findViewById(R.id.NorthMin);
        TextView Stime= findViewById(R.id.SouthMin);

        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        Stop tempObj = stopsObj.ClosestStop(latitude);

        Calendar calendar = Calendar.getInstance();
        int currentHours = LocalDateTime.now().getHour();
        int currentMinute = LocalDateTime.now().getMinute();
        //int seconds = calendar.get(Calendar.SECOND);

        if (tempObj.isExtended() == true){
            currentMinute = currentMinute % 30;
        }
        else{
            currentMinute = currentMinute % 15;
        }

        int northFrequencyIndex = tempObj.getNorthFrequency();
        if(currentMinute > northFrequencyIndex) {
            if (tempObj.isExtended() == true){
                northFrequencyIndex += 30;
            }
            else{
                northFrequencyIndex += 15;
            }
        }
        if((currentHours == 0) && ((LocalDateTime.now().getMinute() + 15) > 60) && (currentMinute > tempObj.getNorthFrequency())){
            Stime.setText(Math.abs(currentMinute - northFrequencyIndex) + " Minutes Last");
        }
        else {
            Ntime.setText(Math.abs(currentMinute - northFrequencyIndex) + " Minutes");
        }

        int southFrequencyIndex = tempObj.getSouthFrequency();
        if(currentMinute > southFrequencyIndex) {
            if (tempObj.isExtended() == true){
                southFrequencyIndex += 30;
            }
            else{
                southFrequencyIndex += 15;
            }
        }
        if((currentHours == 0) && ((LocalDateTime.now().getMinute() + 15) > 60) && (currentMinute > tempObj.getSouthFrequency())){
            Stime.setText(Math.abs(currentMinute - southFrequencyIndex) + " Minutes Last");
        }
        else {
            Stime.setText(Math.abs(currentMinute - southFrequencyIndex) + " Minutes");
        }

    }

    boolean ifBusOper(){
        Calendar calendar = Calendar.getInstance();
        int currentHours = LocalDateTime.now().getHour();
        int currentMinute = LocalDateTime.now().getMinute();
        //int seconds = calendar.get(Calendar.SECOND);
        if( (currentHours < 6) && (currentHours > 1 )){
            return false;
        }
        else {
            return true;
        }
    }
}