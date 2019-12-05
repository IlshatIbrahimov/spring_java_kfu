package com.spacex.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

@Data
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


    public static Flight getFlight(String flightId) {
        Flight flight = new Flight();
        JsonObject data = getData(flightId);
        flight.initInfo(data);
        flight.imageUrl = getImage(data);
        return flight;
    }

    public static Flight getFlight(int flightId) {
        return getFlight(String.valueOf(flightId));
    }

    public static List<Flight> getAllFlights() {
        List<Flight> allFlights = new ArrayList<>();
        URL url;
        HttpURLConnection request;
        JsonArray res = new JsonArray();
        try {
            url = new URL("https://api.spacexdata.com/v3/launches");
            request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
            res = root.getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < Integer.parseInt(getData("latest").get("flight_number").toString()); i++) {
            Flight flight = new Flight();
            JsonObject data = res.get(i).getAsJsonObject();
            flight.initInfo(data);
            allFlights.add(flight);
        }

        Collections.reverse(allFlights);
        return allFlights;
    }

    private void initInfo(JsonObject data) {
        flightNumber = data.get("flight_number").toString();
        flightName = data.get("mission_name").toString().replaceAll("\"", "");
        description = data.get("details").toString();
        description = description.substring(1, description.length() - 1);
        launchDate = data.get("launch_date_local").toString().replaceAll("\"", "");
        rocketName = data.get("rocket").getAsJsonObject().get("rocket_name").toString().replaceAll("\"", "");
        launchSuccess = data.get("launch_success").toString();
        wikipedia = data.get("links").getAsJsonObject().get("wikipedia").toString().replaceAll("\"", "");
        videoLink = data.get("links").getAsJsonObject().get("youtube_id").toString().replaceAll("\"", "");
        missionPatchUrl = data.get("links").getAsJsonObject().get("mission_patch_small").toString().replaceAll("\"", "");
    }

    private static JsonObject getData(String dataId) {
        URL url;
        HttpURLConnection request;
        JsonObject res = new JsonObject();
        try {
            url = new URL(format("https://api.spacexdata.com/v3/launches/%s", dataId));
            request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
            res = root.getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private static String getImage(JsonObject data) {
        String[] images = data.get("links").getAsJsonObject().get("flickr_images").toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "").split(",");
        String image;
        int minWidth = -1;
        int minWidthId = 0;
        try {
            for (int i = 0; i < images.length; i++) {
                URL url = new URL(images[i]);
                BufferedImage bi = ImageIO.read(url);

                if (minWidth == -1) {
                    minWidth = bi.getWidth();
                    minWidthId = i;
                    continue;
                }

                if (bi.getWidth() < minWidth) {
                    minWidth = bi.getWidth();
                    minWidthId = i;
                }

                if (bi.getWidth() < bi.getHeight()) {
                    return images[i];
                }
            }
            return images[minWidthId];
        } catch (IOException e) {
            image = "https://www.doz.com/cms/wp-content/uploads/2015/03/spacex-logo.jpg";
            return image;
        }

    }

}