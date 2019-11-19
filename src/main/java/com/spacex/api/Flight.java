package com.spacex.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class Flight {

    private String flightNumber;
    private String flightName;
    private String description;
    private String launchDate;
    private String rocketName;
    private String launchSuccess;
    private String wikipedia;
    private String videoLink;
    private String missionPatchUrl;
    private String imageUrl;


    public static Flight getFlight(String flightId){
        Flight flight = new Flight();
        flight.initInfo(flightId);
        String[] images = getData(flightId).get("links").getAsJsonObject().get("flickr_images").toString().replaceAll("\\[","").replaceAll("\\]","").replaceAll("\"","").split(",");
        flight.imageUrl = getImage(images);
        return flight;
    }

    public static Flight getFlight(int flightId){
        return getFlight(String.valueOf(flightId));
    }

    public static List<Flight> getAllFlights(){
        List<Flight> allFlights = new ArrayList<>();
        for (int i = 1; i <= Integer.parseInt(getData("latest").get("flight_number").toString()); i++) {
            Flight flight = getFlight(i);
            flight.imageUrl = null;
            allFlights.add(flight);
        }
        return allFlights;
    }

    private void initInfo(String flightId){
        JsonObject data = getData(flightId);
        flightNumber = data.get("flight_number").toString();
        flightName = data.get("mission_name").toString().replaceAll("\"","");
        description = data.get("details").toString();
        description = description.substring(1, description.length()-1);
        launchDate = data.get("launch_date_local").toString().replaceAll("\"","");
        rocketName = data.get("rocket").getAsJsonObject().get("rocket_name").toString().replaceAll("\"","");
        launchSuccess = data.get("launch_success").toString();
        wikipedia = data.get("links").getAsJsonObject().get("wikipedia").toString().replaceAll("\"", "");
        videoLink = data.get("links").getAsJsonObject().get("youtube_id").toString().replaceAll("\"","");
        missionPatchUrl = data.get("links").getAsJsonObject().get("mission_patch_small").toString().replaceAll("\"","");
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

    private static String getImage(String[] images){
        String image = "";
        int minHeight = 0;
        int minHeightId = 0;
        try{
            for (int i = 0; i < images.length; i++) {
                URL url = new URL(images[i]);
                final BufferedImage bi = ImageIO.read(url);
                if (bi.getHeight() < minHeight){
                    minHeight = bi.getHeight();
                    minHeightId = i;
                }
                if (bi.getHeight() < bi.getWidth()){
                    image = images[i];
                    break;
                }
            }
            if (image.isEmpty()){
                image = images[minHeightId];
            }
        }
        catch (IOException e){
            image = "https://www.doz.com/cms/wp-content/uploads/2015/03/spacex-logo.jpg";
        }
        return image;
    }

}
