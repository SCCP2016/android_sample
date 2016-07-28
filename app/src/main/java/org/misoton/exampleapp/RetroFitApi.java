package org.misoton.exampleapp;


import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RetroFitApi {
//    @FormUrlEncoded
//    @POST("/NikkoNews/api")
//    void load_all_news(@Field("locale") String locate , Callback<List<NewsData>> cb);

    @GET("/data/2.5/forecast/daily")
    void daily(@Query("q") String location, @Query("cnt") int count, @Query("appid") String appId, Callback<Weather> cb);
}
