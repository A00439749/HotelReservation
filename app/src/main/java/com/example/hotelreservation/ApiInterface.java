package com.example.hotelreservation;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;

public interface ApiInterface {
    @GET("/getlistofhotels")
    public void getHotelsLists(Callback<List<HotelListData>> callback);
}
