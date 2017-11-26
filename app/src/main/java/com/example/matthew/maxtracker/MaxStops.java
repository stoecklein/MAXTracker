package com.example.matthew.maxtracker;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Data for each stop on the Max line
 */

public class MaxStops {
    MaxStops(Context mContext){
        //For getting location
        this.mContext = mContext;

        fillStopList();
        fillRouteList();
    }

    Context mContext;
    Time maxTime = new Time(6,1, mContext); //Creating a Time object with Max Times
    BusMap maxMap = new BusMap(mContext);   //BusMap object for handing map logic

    // List of stop objects for each max stop
    final private List<Stop> maxStopList = new ArrayList<Stop>();

    //List of route objects for the Max route
    final private List<Route> maxRouteList = new ArrayList<Route>();

    // Start and end points for show direction on the UI
    final private String[] endStops = {"To River Market", "To Waldo"};



    // Pre-condition: A list of Route objects has been initialized
    // Post-condition: maxRouteList contains every stop added
    void fillRouteList(){
        maxRouteList.add(new Route(39.110462, -94.580374));
        maxRouteList.add(new Route(39.110344, -94.580961));
        maxRouteList.add(new Route(39.109730, -94.580757));
        maxRouteList.add(new Route(39.108806, -94.580432));
        maxRouteList.add(new Route(39.110462, -94.580374));
        maxRouteList.add(new Route(39.110344, -94.580961));//3 & Grand
        maxRouteList.add(new Route(39.109730, -94.580757));
        maxRouteList.add(new Route(39.108806, -94.580432));
        maxRouteList.add(new Route(39.108454, -94.580325));
        maxRouteList.add(new Route(39.107863, -94.580140));
        maxRouteList.add(new Route(39.107782, -94.580111));
        maxRouteList.add(new Route(39.107724, -94.580095));
        maxRouteList.add(new Route(39.107674, -94.580076));
        maxRouteList.add(new Route(39.107616, -94.580063));
        maxRouteList.add(new Route(39.107553, -94.580046));
        maxRouteList.add(new Route(39.107480, -94.580037));
        maxRouteList.add(new Route(39.107402, -94.580033));
        maxRouteList.add(new Route(39.107317, -94.580043));
        maxRouteList.add(new Route(39.106745, -94.580147));
        maxRouteList.add(new Route(39.106471, -94.580212));
        maxRouteList.add(new Route(39.106222, -94.580299));//6 & Grand
        maxRouteList.add(new Route(39.105435, -94.580539));
        maxRouteList.add(new Route(39.105346, -94.580614));
        maxRouteList.add(new Route(39.105309, -94.580630));
        maxRouteList.add(new Route(39.105271, -94.580643));
        maxRouteList.add(new Route(39.105223, -94.580646));
        maxRouteList.add(new Route(39.104800, -94.580653));
        maxRouteList.add(new Route(39.104431, -94.580672));//8 & Grand
        maxRouteList.add(new Route(39.103494, -94.580718));//9 & Grand
        maxRouteList.add(new Route(39.102287, -94.580770));//10 & Grand
        maxRouteList.add(new Route(39.101056, -94.580841));
        maxRouteList.add(new Route(39.100072, -94.580890));
        maxRouteList.add(new Route(39.099876, -94.580919));//12
        maxRouteList.add(new Route(39.098542, -94.580977));//13
        maxRouteList.add(new Route(39.097445, -94.581024));
        maxRouteList.add(new Route(39.097181, -94.581046));
        maxRouteList.add(new Route(39.096320, -94.581085));
        maxRouteList.add(new Route(39.095711, -94.581127));
        maxRouteList.add(new Route(39.094453, -94.581195));//16
        maxRouteList.add(new Route(39.093365, -94.581245));
        maxRouteList.add(new Route(39.091721, -94.581333));
        maxRouteList.add(new Route(39.090360, -94.581406));
        maxRouteList.add(new Route(39.089049, -94.581465));//20
        maxRouteList.add(new Route(39.087761, -94.581525));
        maxRouteList.add(new Route(39.086845, -94.581561));
        maxRouteList.add(new Route(39.086402, -94.581570));
        maxRouteList.add(new Route(39.086213, -94.581588));
        maxRouteList.add(new Route(39.086095, -94.581594));
        maxRouteList.add(new Route(39.085035, -94.581649));
        maxRouteList.add(new Route(39.084074, -94.581682));//Pershing & Grand
        maxRouteList.add(new Route(39.082926, -94.581760));
        maxRouteList.add(new Route(39.082724, -94.581779));
        maxRouteList.add(new Route(39.082621, -94.581795));
        maxRouteList.add(new Route(39.082536, -94.581811));
        maxRouteList.add(new Route(39.082455, -94.581837));
        maxRouteList.add(new Route(39.082322, -94.581880));
        maxRouteList.add(new Route(39.082078, -94.581987));
        maxRouteList.add(new Route(39.081844, -94.582120));
        maxRouteList.add(new Route(39.081758, -94.582181));
        maxRouteList.add(new Route(39.081431, -94.582334));
        maxRouteList.add(new Route(39.080338, -94.582989));
        maxRouteList.add(new Route(39.080245, -94.583040));
        maxRouteList.add(new Route(39.080180, -94.583079));
        maxRouteList.add(new Route(39.080120, -94.583101));
        maxRouteList.add(new Route(39.080078, -94.583114));
        maxRouteList.add(new Route(39.080027, -94.583124));
        maxRouteList.add(new Route(39.079886, -94.583131));
        maxRouteList.add(new Route(39.079428, -94.583166));//26
        maxRouteList.add(new Route(39.079265, -94.583180));
        maxRouteList.add(new Route(39.079202, -94.583191));
        maxRouteList.add(new Route(39.079145, -94.583207));
        maxRouteList.add(new Route(39.079064, -94.583238));
        maxRouteList.add(new Route(39.078967, -94.583274));
        maxRouteList.add(new Route(39.078856, -94.583329));
        maxRouteList.add(new Route(39.078733, -94.583410));
        maxRouteList.add(new Route(39.078611, -94.583491));
        maxRouteList.add(new Route(39.078533, -94.583537));
        maxRouteList.add(new Route(39.078475, -94.583560));
        maxRouteList.add(new Route(39.078416, -94.583585));
        maxRouteList.add(new Route(39.078367, -94.583599));
        maxRouteList.add(new Route(39.078323, -94.583611));
        maxRouteList.add(new Route(39.078257, -94.583622));
        maxRouteList.add(new Route(39.078182, -94.583636));//27
        maxRouteList.add(new Route(39.077848, -94.583659));
        maxRouteList.add(new Route(39.077428, -94.583680));
        maxRouteList.add(new Route(39.077371, -94.583696));
        maxRouteList.add(new Route(39.077310, -94.583709));
        maxRouteList.add(new Route(39.077230, -94.583730));
        maxRouteList.add(new Route(39.077158, -94.583748));
        maxRouteList.add(new Route(39.077064, -94.583794));
        maxRouteList.add(new Route(39.076962, -94.583848));
        maxRouteList.add(new Route(39.076869, -94.583912));
        maxRouteList.add(new Route(39.076773, -94.583993));
        maxRouteList.add(new Route(39.076671, -94.584090));
        maxRouteList.add(new Route(39.076596, -94.584185));
        maxRouteList.add(new Route(39.076506, -94.584301));
        maxRouteList.add(new Route(39.076432, -94.584418));
        maxRouteList.add(new Route(39.076374, -94.584540));
        maxRouteList.add(new Route(39.076365, -94.584557));
        maxRouteList.add(new Route(39.076338, -94.584633));
        maxRouteList.add(new Route(39.076330, -94.584727));
        maxRouteList.add(new Route(39.076317, -94.584806));
        maxRouteList.add(new Route(39.076324, -94.584870));
        maxRouteList.add(new Route(39.076330, -94.584936));//Main & Grand
        maxRouteList.add(new Route(39.074769, -94.585092));
        maxRouteList.add(new Route(39.074113, -94.585145));
        maxRouteList.add(new Route(39.073503, -94.585237));
        maxRouteList.add(new Route(39.072828, -94.585261));//30
        maxRouteList.add(new Route(39.071031, -94.585300));
        maxRouteList.add(new Route(39.070036, -94.585334));
        maxRouteList.add(new Route(39.069787, -94.585354));
        maxRouteList.add(new Route(39.069196, -94.585368));
        maxRouteList.add(new Route(39.068359, -94.585426));//Linwood
        maxRouteList.add(new Route(39.067402, -94.585451));
        maxRouteList.add(new Route(39.066339, -94.585514));
        maxRouteList.add(new Route(39.065762, -94.585548));
        maxRouteList.add(new Route(39.064813, -94.585576));
        maxRouteList.add(new Route(39.063794, -94.585648));//Armour
        maxRouteList.add(new Route(39.061992, -94.585752));
        maxRouteList.add(new Route(39.060179, -94.585892));
        maxRouteList.add(new Route(39.058387, -94.585992));
        maxRouteList.add(new Route(39.056581, -94.586105));//39
        maxRouteList.add(new Route(39.055325, -94.586176));
        maxRouteList.add(new Route(39.054178, -94.586251));
        maxRouteList.add(new Route(39.053009, -94.586322));
        maxRouteList.add(new Route(39.051765, -94.586385));
        maxRouteList.add(new Route(39.050606, -94.586460));
        maxRouteList.add(new Route(39.049339, -94.586519));//43
        maxRouteList.add(new Route(39.048011, -94.586594));
        maxRouteList.add(new Route(39.046595, -94.586669));
        maxRouteList.add(new Route(39.045649, -94.586744));
        maxRouteList.add(new Route(39.045328, -94.586771));
        maxRouteList.add(new Route(39.045170, -94.586771));
        maxRouteList.add(new Route(39.044637, -94.586781));
        maxRouteList.add(new Route(39.043654, -94.586830));
        maxRouteList.add(new Route(39.042854, -94.586872));
        maxRouteList.add(new Route(39.042562, -94.586824));
        maxRouteList.add(new Route(39.042158, -94.586733));
        maxRouteList.add(new Route(39.042216, -94.588037));
        maxRouteList.add(new Route(39.041141, -94.588079));
        maxRouteList.add(new Route(39.040791, -94.588096));
        maxRouteList.add(new Route(39.040254, -94.588146));
        maxRouteList.add(new Route(39.039995, -94.588148));
        maxRouteList.add(new Route(39.039937, -94.587033));
        maxRouteList.add(new Route(39.039600, -94.587056));
        maxRouteList.add(new Route(39.038948, -94.587107));
        maxRouteList.add(new Route(39.038541, -94.587144));
        maxRouteList.add(new Route(39.037530, -94.587183));
        maxRouteList.add(new Route(39.036655, -94.587227));
        maxRouteList.add(new Route(39.035710, -94.587274));
        maxRouteList.add(new Route(39.034891, -94.587318));//51 & Main
        maxRouteList.add(new Route(39.034845, -94.586157));
        maxRouteList.add(new Route(39.034813, -94.585026));
        maxRouteList.add(new Route(39.034764, -94.584254));//51 & Brookside
        maxRouteList.add(new Route(39.034224, -94.584240));
        maxRouteList.add(new Route(39.033415, -94.584227));
        maxRouteList.add(new Route(39.032686, -94.584165));
        maxRouteList.add(new Route(39.032322, -94.584151));
        maxRouteList.add(new Route(39.031776, -94.584130));
        maxRouteList.add(new Route(39.031679, -94.584130));
        maxRouteList.add(new Route(39.031609, -94.584147));
        maxRouteList.add(new Route(39.031481, -94.584175));
        maxRouteList.add(new Route(39.031425, -94.584195));
        maxRouteList.add(new Route(39.031139, -94.584299));
        maxRouteList.add(new Route(39.031057, -94.584328));
        maxRouteList.add(new Route(39.030826, -94.584356));
        maxRouteList.add(new Route(39.029201, -94.584419));
        maxRouteList.add(new Route(39.028958, -94.584425));
        maxRouteList.add(new Route(39.029201, -94.584419));
        maxRouteList.add(new Route(39.028811, -94.584434));
        maxRouteList.add(new Route(39.028575, -94.584476));
        maxRouteList.add(new Route(39.028424, -94.584500));
        maxRouteList.add(new Route(39.028347, -94.584524));
        maxRouteList.add(new Route(39.028020, -94.584611));
        maxRouteList.add(new Route(39.027566, -94.584781));//55 & Brookside
        maxRouteList.add(new Route(39.026662, -94.585153));
        maxRouteList.add(new Route(39.025949, -94.585470));
        maxRouteList.add(new Route(39.024895, -94.585949));
        maxRouteList.add(new Route(39.024232, -94.586246));
        maxRouteList.add(new Route(39.024004, -94.586351));
        maxRouteList.add(new Route(39.023186, -94.586741));
        maxRouteList.add(new Route(39.022361, -94.587140));//58 & Brookside
        maxRouteList.add(new Route(39.021901, -94.587359));
        maxRouteList.add(new Route(39.020962, -94.587812));
        maxRouteList.add(new Route(39.020464, -94.588175));
        maxRouteList.add(new Route(39.020183, -94.588423));
        maxRouteList.add(new Route(39.019657, -94.588841));
        maxRouteList.add(new Route(39.019400, -94.589004));
        maxRouteList.add(new Route(39.017884, -94.589692));
        maxRouteList.add(new Route(39.017463, -94.589888));//61 & Brookside
        maxRouteList.add(new Route(39.016593, -94.590303));
        maxRouteList.add(new Route(39.015737, -94.590694));//62 & Brookside
        maxRouteList.add(new Route(39.014908, -94.591068));
        maxRouteList.add(new Route(39.014016, -94.591499));//63 & Brookside
        maxRouteList.add(new Route(39.012947, -94.591994));
        maxRouteList.add(new Route(39.012617, -94.592148));
        maxRouteList.add(new Route(39.012569, -94.592170));
        maxRouteList.add(new Route(39.012523, -94.592183));
        maxRouteList.add(new Route(39.012475, -94.592197));
        maxRouteList.add(new Route(39.012248, -94.592225));//Meyer & Brookside
        maxRouteList.add(new Route(39.012264, -94.592683));
        maxRouteList.add(new Route(39.012272, -94.593155));
        maxRouteList.add(new Route(39.010470, -94.593170));//65 & Wornall
        maxRouteList.add(new Route(39.010261, -94.593178));
        maxRouteList.add(new Route(39.008207, -94.593271));
        maxRouteList.add(new Route(39.007347, -94.593313));
        maxRouteList.add(new Route(39.006676, -94.593351));
        maxRouteList.add(new Route(39.004787, -94.593450));
        maxRouteList.add(new Route(39.003644, -94.593518));//69 & Wornall
        maxRouteList.add(new Route(39.001874, -94.593644));//70 & Wornall
        maxRouteList.add(new Route(39.001085, -94.593708));
        maxRouteList.add(new Route(39.000336, -94.593795));
        maxRouteList.add(new Route(38.999595, -94.593841));
        maxRouteList.add(new Route(38.997788, -94.593934));//72 & Wornall
        maxRouteList.add(new Route(38.995973, -94.594079));//73 & Wornall
        maxRouteList.add(new Route(38.994156, -94.594213));//74 & Wornall
        maxRouteList.add(new Route(38.994132, -94.593722));
        maxRouteList.add(new Route(38.993590, -94.593757));
        maxRouteList.add(new Route(38.993336, -94.593783));//loop back to 74 & Wornall
    }

    // Pre-condition: A list of Stop objects has been initialized
    // Post-condition: maxStopList contains every stop added
    void fillStopList(){
        maxStopList.add(new Stop(0, "3rd & Grand", "River Market", 39.110462, -94.580374, 7, 13, false));
        maxStopList.add(new Stop(1, "5th & Grand", "City Market", 39.108897, -94.580481, 8, 12, false));
        maxStopList.add(new Stop(2, "9th & Grand", "Courthouse", 39.103494, -94.580707, 9, 11, false));
        maxStopList.add(new Stop(3, "10 & Grand", "Financial District", 39.101119, -94.580826, 10, 10, false));
        maxStopList.add(new Stop(4, "12th & Grand", "Arena", 39.099873, -94.580918, 11, 9, false));
        maxStopList.add(new Stop(5, "16th & Grand", "Crossroads Arts District", 39.094459, -94.581199, 0, 7, false));
        maxStopList.add(new Stop(6, "19th & Grand", "Crossroads Arts District", 39.090433, -94.581396, 4, 3, false));
        maxStopList.add(new Stop(7, "22nd & Grand", "Washington Sq. Park", 39.086061, -94.581599, 4, 2, false));
        maxStopList.add(new Stop(8, "Pershing & Grand", "Crown Center", 39.083593, -94.581720, 5, 1, false));
        maxStopList.add(new Stop(9, "29th & Main", "Liberty Memorial", 39.074763, -94.585088, 6, 0, false));
        maxStopList.add(new Stop(10, "31st & Main", "Union Hill", 39.070939, -94.585297, 7, 0, false));
        maxStopList.add(new Stop(11, "Linwood & Main", "On Main at Linwood", 39.068265, -94.585429, 8, 15, false));
        maxStopList.add(new Stop(12, "Armour & Main", "On Main at Armour", 39.063798, -94.585644, 9, 14, false));
        maxStopList.add(new Stop(13, "39th & Main", "39th", 39.056568, -94.586100, 10, 11, false));
        maxStopList.add(new Stop(14, "43rd & Main", "43rd", 39.049334, -94.586518, 11, 10, false));
        maxStopList.add(new Stop(15, "45th & Main", "Art Museums", 39.046319, -94.586688, 12, 9, false));
        maxStopList.add(new Stop(16, "47th & Main", "Country Club Plaza", 39.041274, -94.588069, 14, 6, false));
        maxStopList.add(new Stop(17, "49th & Main", "Plaza Library", 39.038987, -94.587116, 15, 20, true));
        maxStopList.add(new Stop(18, "52st & Brookside", "UMKC", 39.034369, -94.584249, 16, 19, true));
        maxStopList.add(new Stop(19, "55th & Brookside", "Brookside", 39.027420, -94.584853, 17, 18, true));
        maxStopList.add(new Stop(20, "59th & Brookside", "Brookside", 39.020285, -94.588330, 19, 16, true));
        maxStopList.add(new Stop(21, "63rd & Brookside", "Brookside", 39.013916, -94.591547, 21, 14, true));
        maxStopList.add(new Stop(22, "Gregory & Wornall", "Gregory", 38.999689, -94.593838, 23, 11, true));
        maxStopList.add(new Stop(23, "75th & Wornall", "Waldo", 38.993336, -94.593783, 25, 9, true));

    }

    // Passes map and maxStopList to BusMap class to handle logic
    void addMapMarkers(GoogleMap map){
        try {
            assert map != null;
        }
        catch (AssertionError e) {
            System.exit(0);
        }

        maxMap.addMarkers(map, maxStopList);
    }

    // Passes map and maxRouteList to BusMap class to handle logic
    void addRouteLine(GoogleMap map){
        try {
            assert map != null;
        }
        catch (AssertionError e) {
            System.exit(0);
        }

        maxMap.addRoute(map, maxRouteList);
    }

    // Returns a users current latitude via API
    // For being able to update location as needed
    double getLatitude(){
        LocationManager lm = (LocationManager)mContext.getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        return latitude;
    }

    // Returns a users current latitude via API
    // For being able to update location as needed
    double getLongitude(){
        LocationManager lm = (LocationManager)mContext.getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        //double latitude = location.getLatitude();
        return longitude;
    }

    // Calls Time class to handle logic
    boolean isInOperation(){
        return maxTime.isBusOper();
    }

    // Pre-condition: maxStopList isn't empty
    // Post-condition: Returns the stop object closest in latitude to the user
    Stop ClosestStop (double latIn){
        return maxMap.closestStop(maxStopList, latIn);
    }

    // Gets closest stop at the moment and passes logic to Time class
    public void updateTimeRemaining(TextView Ntime, TextView directionText, int direction){
        Stop temp = ClosestStop(getLatitude());
        maxTime.TimeRemaining(Ntime, directionText, direction, endStops, temp);
    }

    // Gets closest stop at the moment and updates text on UI
    public void updateStopLoc(TextView curLoc){
        Stop tempObj = ClosestStop(getLatitude());
        curLoc.setText(tempObj.getName());
    }

    public void showRealTime(GoogleMap map){
        //Get real time location
        double lat = 39.089538;
        double lon = -94.581437;

        map.addMarker(new MarkerOptions()
                .position(new LatLng(lat, lon))
                //.title(itrObject.getName())
                //.snippet(itrObject.getSnippet())
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_live_blue)));

    }

}