package com.example.matthew.maxtracker;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.052397, -94.586374) , 12.25f) );


        PolylineOptions rectOptions = new PolylineOptions()
                .width(10)
                .color(Color.RED)

                .add(new LatLng(39.110462, -94.580374))
                .add(new LatLng(39.110344, -94.580961))//3 & Grand
                .add(new LatLng(39.109730, -94.580757))
                .add(new LatLng(39.108806, -94.580432))
                .add(new LatLng(39.108454, -94.580325))
                .add(new LatLng(39.107863, -94.580140))
                .add(new LatLng(39.107782, -94.580111))
                .add(new LatLng(39.107724, -94.580095))
                .add(new LatLng(39.107674, -94.580076))
                .add(new LatLng(39.107616, -94.580063))
                .add(new LatLng(39.107553, -94.580046))
                .add(new LatLng(39.107480, -94.580037))
                .add(new LatLng(39.107402, -94.580033))
                .add(new LatLng(39.107317, -94.580043))
                .add(new LatLng(39.106745, -94.580147))
                .add(new LatLng(39.106471, -94.580212))
                .add(new LatLng(39.106222, -94.580299))//6 & Grand
                .add(new LatLng(39.105435, -94.580539))
                .add(new LatLng(39.105346, -94.580614))
                .add(new LatLng(39.105309, -94.580630))
                .add(new LatLng(39.105271, -94.580643))
                .add(new LatLng(39.105223, -94.580646))
                .add(new LatLng(39.104800, -94.580653))
                .add(new LatLng(39.104431, -94.580672))//8 & Grand
                .add(new LatLng(39.103494, -94.580718))//9 & Grand
                .add(new LatLng(39.102287, -94.580770))//10 & Grand
                .add(new LatLng(39.101056, -94.580841))
                .add(new LatLng(39.100072, -94.580890))
                .add(new LatLng(39.099876, -94.580919))//12
                .add(new LatLng(39.098542, -94.580977))//13
                .add(new LatLng(39.097445, -94.581024))
                .add(new LatLng(39.097181, -94.581046))
                .add(new LatLng(39.096320, -94.581085))
                .add(new LatLng(39.095711, -94.581127))
                .add(new LatLng(39.094453, -94.581195))//16
                .add(new LatLng(39.093365, -94.581245))
                .add(new LatLng(39.091721, -94.581333))
                .add(new LatLng(39.090360, -94.581406))
                .add(new LatLng(39.089049, -94.581465))//20
                .add(new LatLng(39.087761, -94.581525))
                .add(new LatLng(39.086845, -94.581561))
                .add(new LatLng(39.086402, -94.581570))
                .add(new LatLng(39.086213, -94.581588))
                .add(new LatLng(39.086095, -94.581594))
                .add(new LatLng(39.085035, -94.581649))
                .add(new LatLng(39.084074, -94.581682))//Pershing & Grand
                .add(new LatLng(39.082926, -94.581760))
                .add(new LatLng(39.082724, -94.581779))
                .add(new LatLng(39.082621, -94.581795))
                .add(new LatLng(39.082536, -94.581811))
                .add(new LatLng(39.082455, -94.581837))
                .add(new LatLng(39.082322, -94.581880))
                .add(new LatLng(39.082078, -94.581987))
                .add(new LatLng(39.081844, -94.582120))
                .add(new LatLng(39.081758, -94.582181))
                .add(new LatLng(39.081431, -94.582334))
                .add(new LatLng(39.080338, -94.582989))
                .add(new LatLng(39.080245, -94.583040))
                .add(new LatLng(39.080180, -94.583079))
                .add(new LatLng(39.080120, -94.583101))
                .add(new LatLng(39.080078, -94.583114))
                .add(new LatLng(39.080027, -94.583124))
                .add(new LatLng(39.079886, -94.583131))
                .add(new LatLng(39.079428, -94.583166))//26
                .add(new LatLng(39.079265, -94.583180))
                .add(new LatLng(39.079202, -94.583191))
                .add(new LatLng(39.079145, -94.583207))
                .add(new LatLng(39.079064, -94.583238))
                .add(new LatLng(39.078967, -94.583274))
                .add(new LatLng(39.078856, -94.583329))
                .add(new LatLng(39.078733, -94.583410))
                .add(new LatLng(39.078611, -94.583491))
                .add(new LatLng(39.078533, -94.583537))
                .add(new LatLng(39.078475, -94.583560))
                .add(new LatLng(39.078416, -94.583585))
                .add(new LatLng(39.078367, -94.583599))
                .add(new LatLng(39.078323, -94.583611))
                .add(new LatLng(39.078257, -94.583622))
                .add(new LatLng(39.078182, -94.583636))//27
                .add(new LatLng(39.077848, -94.583659))
                .add(new LatLng(39.077428, -94.583680))
                .add(new LatLng(39.077371, -94.583696))
                .add(new LatLng(39.077310, -94.583709))
                .add(new LatLng(39.077230, -94.583730))
                .add(new LatLng(39.077158, -94.583748))
                .add(new LatLng(39.077064, -94.583794))
                .add(new LatLng(39.076962, -94.583848))
                .add(new LatLng(39.076869, -94.583912))
                .add(new LatLng(39.076773, -94.583993))
                .add(new LatLng(39.076671, -94.584090))
                .add(new LatLng(39.076596, -94.584185))
                .add(new LatLng(39.076506, -94.584301))
                .add(new LatLng(39.076432, -94.584418))
                .add(new LatLng(39.076374, -94.584540))
                .add(new LatLng(39.076365, -94.584557))
                .add(new LatLng(39.076338, -94.584633))
                .add(new LatLng(39.076330, -94.584727))
                .add(new LatLng(39.076317, -94.584806))
                .add(new LatLng(39.076324, -94.584870))
                .add(new LatLng(39.076330, -94.584936))//Main & Grand
                .add(new LatLng(39.074769, -94.585092))
                .add(new LatLng(39.074113, -94.585145))
                .add(new LatLng(39.073503, -94.585237))
                .add(new LatLng(39.072828, -94.585261))//30
                .add(new LatLng(39.071031, -94.585300))
                .add(new LatLng(39.070036, -94.585334))
                .add(new LatLng(39.069787, -94.585354))
                .add(new LatLng(39.069196, -94.585368))
                .add(new LatLng(39.068359, -94.585426))//Linwood
                .add(new LatLng(39.067402, -94.585451))
                .add(new LatLng(39.066339, -94.585514))
                .add(new LatLng(39.065762, -94.585548))
                .add(new LatLng(39.064813, -94.585576))
                .add(new LatLng(39.063794, -94.585648))//Armour
                .add(new LatLng(39.061992, -94.585752))
                .add(new LatLng(39.060179, -94.585892))
                .add(new LatLng(39.058387, -94.585992))
                .add(new LatLng(39.056581, -94.586105))//39
                .add(new LatLng(39.055325, -94.586176))
                .add(new LatLng(39.054178, -94.586251))
                .add(new LatLng(39.053009, -94.586322))
                .add(new LatLng(39.051765, -94.586385))
                .add(new LatLng(39.050606, -94.586460))
                .add(new LatLng(39.049339, -94.586519))//43
                .add(new LatLng(39.048011, -94.586594))
                .add(new LatLng(39.046595, -94.586669))
                .add(new LatLng(39.045649, -94.586744))
                .add(new LatLng(39.045328, -94.586771))
                .add(new LatLng(39.045170, -94.586771))
                .add(new LatLng(39.044637, -94.586781))
                .add(new LatLng(39.043654, -94.586830))
                .add(new LatLng(39.042854, -94.586872))
                .add(new LatLng(39.042562, -94.586824))
                .add(new LatLng(39.042158, -94.586733))
                .add(new LatLng(39.042216, -94.588037))
                .add(new LatLng(39.041141, -94.588079))
                .add(new LatLng(39.040791, -94.588096))
                .add(new LatLng(39.040254, -94.588146))
                .add(new LatLng(39.039995, -94.588148))
                .add(new LatLng(39.039937, -94.587033))
                .add(new LatLng(39.039600, -94.587056))
                .add(new LatLng(39.038948, -94.587107))
                .add(new LatLng(39.038541, -94.587144))
                .add(new LatLng(39.037530, -94.587183))
                .add(new LatLng(39.036655, -94.587227))
                .add(new LatLng(39.035710, -94.587274))
                .add(new LatLng(39.034891, -94.587318))//51 & Main
                .add(new LatLng(39.034486, -94.587332))
                .add(new LatLng(39.033533, -94.587385))
                .add(new LatLng(39.032645, -94.587441))//52 & Main
                .add(new LatLng(39.031805, -94.587473))
                .add(new LatLng(39.030949, -94.587531))//53
                .add(new LatLng(39.030065, -94.587594))
                .add(new LatLng(39.029319, -94.587632))
                .add(new LatLng(39.029194, -94.587643))
                .add(new LatLng(39.028479, -94.587671))
                .add(new LatLng(39.027675, -94.587720))//55
                .add(new LatLng(39.027625, -94.586508))
                .add(new LatLng(39.027566, -94.584781))//55 & Brookside
                .add(new LatLng(39.026662, -94.585153))
                .add(new LatLng(39.025949, -94.585470))
                .add(new LatLng(39.024895, -94.585949))
                .add(new LatLng(39.024232, -94.586246))
                .add(new LatLng(39.024004, -94.586351))
                .add(new LatLng(39.023186, -94.586741))
                .add(new LatLng(39.022361, -94.587140))//58 & Brookside
                .add(new LatLng(39.021901, -94.587359))
                .add(new LatLng(39.020962, -94.587812))
                .add(new LatLng(39.020464, -94.588175))
                .add(new LatLng(39.020183, -94.588423))
                .add(new LatLng(39.019657, -94.588841))
                .add(new LatLng(39.019400, -94.589004))
                .add(new LatLng(39.017884, -94.589692))
                .add(new LatLng(39.017463, -94.589888))//61 & Brookside
                .add(new LatLng(39.016593, -94.590303))
                .add(new LatLng(39.015737, -94.590694))//62 & Brookside
                .add(new LatLng(39.014908, -94.591068))
                .add(new LatLng(39.014016, -94.591499))//63 & Brookside
                .add(new LatLng(39.012947, -94.591994))
                .add(new LatLng(39.012617, -94.592148))
                .add(new LatLng(39.012569, -94.592170))
                .add(new LatLng(39.012523, -94.592183))
                .add(new LatLng(39.012475, -94.592197))
                .add(new LatLng(39.012248, -94.592225))//Meyer & Brookside
                .add(new LatLng(39.012264, -94.592683))
                .add(new LatLng(39.012272, -94.593155))
                .add(new LatLng(39.010470, -94.593170))//65 & Wornall
                .add(new LatLng(39.010261, -94.593178))
                .add(new LatLng(39.008207, -94.593271))
                .add(new LatLng(39.007347, -94.593313))
                .add(new LatLng(39.006676, -94.593351))
                .add(new LatLng(39.004787, -94.593450))
                .add(new LatLng(39.003644, -94.593518))//69 & Wornall
                .add(new LatLng(39.001874, -94.593644))//70 & Wornall
                .add(new LatLng(39.001085, -94.593708))
                .add(new LatLng(39.000336, -94.593795))
                .add(new LatLng(38.999595, -94.593841))
                .add(new LatLng(38.997788, -94.593934))//72 & Wornall
                .add(new LatLng(38.995973, -94.594079))//73 & Wornall
                .add(new LatLng(38.994156, -94.594213))//74 & Wornall
                .add(new LatLng(38.994132, -94.593722))
                .add(new LatLng(38.993590, -94.593757))
                .add(new LatLng(38.993336, -94.593783));//loop back to 74 & Wornall

                //.add(new LatLng(39.110430, -94.580544)); // Closes the polyline.

// Get back the mutable Polyline
        Polyline polyline = mMap.addPolyline(rectOptions);
    }


    
}