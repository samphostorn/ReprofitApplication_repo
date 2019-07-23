package com.example.reprofitapplication.model.response;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("top-headlines")
    Call<ResponeModel> getLatestNews(@Query("sources") String source
            , @Query("apiKey") String apiKey);
}
