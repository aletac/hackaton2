package com.hackaton.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton.rest.model.GeocodeResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GeocodeController {
    @RequestMapping(path = "/geocode", method = RequestMethod.GET )
    public GeocodeResult getGeocode(@RequestParam String address) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://google-maps-geocoding.p.rapidapi.com/geocode/json?latlng=4.630472%2C-74.141389&language=en")
                .get()
                .addHeader("x-rapidapi-host", "google-maps-geocoding.p.rapidapi.com")
                .addHeader("x-rapidapi-key", key)
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        ObjectMapper objectMapper = new ObjectMapper();
        GeocodeResult result = objectMapper.readValue(responseBody.string(), GeocodeResult.class);
        return result;
    }
}

