package org.misoton.exampleapp;


import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

// ここに使いたいAPIを追加していく
public interface RetroFitApi {

    // @Query("hoge") int var で /api?hoge={varの中身} のようにリクエストができるようになる。
    // 最後の引数は Callback<Hoge> 型でなければならない。
    // そのとき Hoge はレスポンスのJSON文字列を受け取れるように定義していなければならない。
    @GET("/data/2.5/forecast/daily")
    void daily(@Query("q") String location, @Query("cnt") int count, @Query("appid") String appId, Callback<Weather> cb);

//    POSTはこんな感じ
//    @FormUrlEncoded
//    @POST("/hoge/api")
//    void load_all_news(@Field("locale") String locate , Callback<List<NewsData>> cb);
}
