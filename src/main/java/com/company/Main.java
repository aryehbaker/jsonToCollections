package com.company;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.company.Restaurant.Restaurant;
import com.company.Restaurant.Restaurants;
import com.google.gson.*;



public class Main {

    public static void main(String[] args) {
	String sURL = "http://34.227.12.12:3000"; //just a string
        URL url = null;
        URLConnection request = null;
        JsonElement root = null;
        JsonArray rootArray = null;
        double lat = 40.613490;
        double longi = -73.951779;
        Type reslist = new com.google.gson.reflect.TypeToken<List<Restaurant>>() {}.getType();
        // Connect to the URL using java's native library
        try {url = new URL(sURL);}catch (java.net.MalformedURLException e){System.out.println(e + " URL");}
        try {request = url.openConnection();
        request.connect();}catch (java.io.IOException e){System.out.println(e + " connection try");}

        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        try {root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        }catch(java.io.IOException e){System.out.println(e + " from getting info");} //Convert the input stream to a json element
        try{rootArray = root.getAsJsonArray();}catch(java.lang.NullPointerException e){System.out.println(e +" from type of response");} //May be an array, may be an object.
        List<Restaurant> res =  new Gson().fromJson(rootArray.toString(),reslist);
        System.out.println(res.toString());
        Restaurant r = res.get(0);
        for(int i = 0; i < res.size();i++){
            System.out.println(r.getName());
            System.out.println(r.getAddress().getBuilding());
            System.out.println(r.getAddress().getStreet());
            System.out.println(r.getAddress().getZipcode());
            System.out.println(r.getAddress().getCoord());
            System.out.println(r.getBorough());
            System.out.println(r.getCuisine());
        }
        HashMap<Double, Restaurant> distance = new HashMap<Double,Restaurant>();
        for (int i = 0; i < res.size(); i++){
            distance.put(res.get(i).getLoc().getCoordinates().get(0),res.get(i));
            
        }

    }
}
