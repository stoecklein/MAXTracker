package com.example.matthew.maxtracker;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by matthew on 10/16/17.
 */

public class MaxStops {
    MaxStops(){
        fillList();
    }
    Time maxTime = new Time();


    void fillList(){
        stopList.add(new Stop(0, "On Grand at 3rd", "River Market", 39.110462, -94.580374, 7, 13, false));
        stopList.add(new Stop(1, "On Grand at 5th", "City Market", 39.108897, -94.580481, 8, 12, false));
        stopList.add(new Stop(2, "On Grand at 9th", "Courthouse", 39.103494, -94.580707, 9, 11, false));
        stopList.add(new Stop(3, "On Grand at 11th", "Financial District", 39.101119, -94.580826, 10, 10, false));
        stopList.add(new Stop(4, "On Grand at 12th", "Arena", 39.099873, -94.580918, 11, 9, false));
        stopList.add(new Stop(5, "On Grand at 16th", "Crossroads Arts District", 39.094459, -94.581199, 0, 7, false));
        stopList.add(new Stop(6, "On Grand at 19th", "Crossroads Arts District", 39.090433, -94.581396, 4, 3, false));
        stopList.add(new Stop(7, "On Grand at 22nd", "Washington Sq. Park", 39.086061, -94.581599, 4, 2, false));
        stopList.add(new Stop(8, "On Grand at Pershing", "Crown Center", 39.083593, -94.581720, 5, 1, false));
        stopList.add(new Stop(9, "On Main at 29th", "Liberty Memorial", 39.074763, -94.585088, 6, 0, false));
        stopList.add(new Stop(10, "On Main at 31st", "Union Hill", 39.070939, -94.585297, 7, 0, false));
        stopList.add(new Stop(11, "On Main at Linwood", "On Main at Linwood", 39.068265, -94.585429, 8, 15, false));
        stopList.add(new Stop(12, "On Main at Armour", "On Main at Armour", 39.063798, -94.585644, 9, 14, false));
        stopList.add(new Stop(13, "On Main at 39th", "39th", 39.056568, -94.586100, 10, 11, false));
        stopList.add(new Stop(14, "On Main at 43rd", "43rd", 39.049334, -94.586518, 11, 10, false));
        stopList.add(new Stop(15, "On Main at 45th", "Art Museums", 39.046319, -94.586688, 12, 9, false));
        stopList.add(new Stop(16, "On Main at 47th", "Country Club Plaza", 39.041274, -94.588069, 14, 6, false));
        stopList.add(new Stop(17, "On Main at 49th", "Plaza Library", 39.038987, -94.587116, 15, 20, true));
        stopList.add(new Stop(18, "On Brookside at 51st", "UMKC", 39.034369, -94.584249, 16, 19, true));
        stopList.add(new Stop(19, "On Brookside at 55th", "Brookside", 39.027420, -94.584853, 17, 18, true));
        stopList.add(new Stop(20, "On Brookside at 59th", "Brookside", 39.020285, -94.588330, 19, 16, true));
        stopList.add(new Stop(21, "On Brookside at 63rd", "Brookside", 39.013916, -94.591547, 21, 14, true));
        stopList.add(new Stop(22, "On Wornall at Gregory", "Gregory", 38.999689, -94.593838, 23, 11, true));
        stopList.add(new Stop(23, "75th at Wornall", "Waldo", 38.993336, -94.593783, 25, 9, true));

    }

    private List<Stop> stopList = new ArrayList<Stop>();
    private int startHour = 6;
    private int endHour = 1;

    //Take in users current lat
    //Return stop object as the closest stop
    Stop ClosestStop (double latIn){

        Iterator<Stop> itr = stopList.iterator();
        Stop itrObject = itr.next();    //Points to northern stop object
        Stop itrObjectNext = itr.next();    //Points to southern stop object

        if(latIn > itrObject.getLat()){
            return itrObject;   //If users lat is north of most northern stop, return first object
        }

        while (itr.hasNext()){

            if (latIn < itrObjectNext.getLat()){    //Move to inspect next stop
                itrObject = itrObjectNext;
                itrObjectNext = itr.next();
            }

            else {  //Current users lat is in between north and south stop objects
                if((Math.abs(itrObjectNext.getLat() - latIn)) > (Math.abs(latIn - itrObject.getLat()))){
                    return itrObject;   //If distance from users lat to north stop is less, return it
                }
                else{
                    return itrObjectNext;//If distance from users lat to south stop is less, return it
                }
            }

        }

        return itrObjectNext;   //If users lat is south of most southern stop, return last object
    }

    //Takes in a Google map object
    //Adds stops to map for every stop object in the stop list
    void addMapMarkers(GoogleMap map){

        Iterator<Stop> itr = stopList.iterator();
        while (itr.hasNext()){

            Stop itrObject = itr.next();

            map.addMarker(new MarkerOptions()
                .position(new LatLng(itrObject.getLat(), itrObject.getLon()))
                .title(itrObject.getName())
                .snippet(itrObject.getSnippet()));
        }
    }

    //Takes in a Google map object
    //Adds route line for Max route
    void addRouteLine(GoogleMap map){
        PolylineOptions rectOptions = new PolylineOptions()
                .width(10)  //Set width for line width
                .color(Color.RED)   //Set color for route line

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
                .add(new LatLng(39.034845, -94.586157))
                .add(new LatLng(39.034813, -94.585026))
                .add(new LatLng(39.034764, -94.584254))//51 & Brookside
                .add(new LatLng(39.034224, -94.584240))
                .add(new LatLng(39.033415, -94.584227))
                .add(new LatLng(39.032686, -94.584165))
                .add(new LatLng(39.032322, -94.584151))
                .add(new LatLng(39.031776, -94.584130))
                .add(new LatLng(39.031679, -94.584130))
                .add(new LatLng(39.031609, -94.584147))
                .add(new LatLng(39.031481, -94.584175))
                .add(new LatLng(39.031425, -94.584195))
                .add(new LatLng(39.031139, -94.584299))
                .add(new LatLng(39.031057, -94.584328))
                .add(new LatLng(39.030826, -94.584356))
                .add(new LatLng(39.029201, -94.584419))
                .add(new LatLng(39.028958, -94.584425))
                .add(new LatLng(39.029201, -94.584419))
                .add(new LatLng(39.028811, -94.584434))
                .add(new LatLng(39.028575, -94.584476))
                .add(new LatLng(39.028424, -94.584500))
                .add(new LatLng(39.028347, -94.584524))
                .add(new LatLng(39.028020, -94.584611))
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

        Polyline polyline = map.addPolyline(rectOptions);// Get back the mutable Polyline
    }

    boolean isInOperation(){
        return maxTime.isBusOper(startHour, endHour);
    }

}