package com.spacex.api;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Flight {

    private String flightName;
    private String description;
    private String launchDate;
    private String rocketName;
    private String launchSuccess;
    private String wikipedia;
    private String videoLink;

    public static Flight getFlight(String flightId){
        Flight flight = new Flight();
        flight.initInfo(flightId);
        return flight;
    }

    public static List<Flight> getAllFlights(){
        List<Flight> allFlights = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(getData("latest").get("flight_number").toString()); i++) {
            Flight flight = new Flight();
            flight.initInfo(String.valueOf(i));
            allFlights.add(flight);
        }
        return allFlights;
    }

    private void initInfo(String flightId){
        JsonObject data = getData(flightId);
        flightName = data.get("mission_name").toString();
        description = data.get("details").toString();
        launchDate = data.get("launch_date_local").toString();
        rocketName = data.get("rocket").getAsJsonObject().get("rocket_name").toString();
        launchSuccess = data.get("launch_success").toString();
        wikipedia = data.get("links").getAsJsonObject().get("wikipedia").toString();
        videoLink = data.get("links").getAsJsonObject().get("video_link").toString();
    }

    private void initInfo(int flightId){
        initInfo(String.valueOf(flightId));
    }

    private static JsonObject getData(String dataId) {
        URL url;
        HttpURLConnection request;
        JsonObject res = new JsonObject();
        try{
            url = new URL(format("https://api.spacexdata.com/v3/launches/%s", dataId));
            request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
            res = root.getAsJsonObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
