package com.example.reprofitapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.reprofitapplication.adapter.MainArticleAdapter;
import com.example.reprofitapplication.model.Article;
import com.example.reprofitapplication.model.response.APIInterface;
import com.example.reprofitapplication.model.response.ApiClient;
import com.example.reprofitapplication.model.response.ResponeModel;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {


    private static final String API_KEY = "ff65b9235ed94e1386549c6d98600708";
    RecyclerView rvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList=findViewById(R.id.rvList);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvList.setLayoutManager(linearLayoutManager);

        final APIInterface apiInterface= ApiClient.getClient().create(APIInterface.class);
        Call<ResponeModel> call=apiInterface.getLatestNews("techcrunch",API_KEY);
        call.enqueue(new Callback<ResponeModel>() {
            @Override
            public void onResponse(Call<ResponeModel> call, Response<ResponeModel> response) {

                if(response.body().getStatus().equals("ok")){
                    List<Article> articleList=response.body().getArticles();

                    Log.e("ssss",articleList.toString());
                    if(articleList.size()>0){


                        final MainArticleAdapter mainArticleAdapter = new MainArticleAdapter(articleList);
                       // mainArticleAdapter.setOnRecyclerViewItemClickListener(MainActivity.this);
                        rvList.setAdapter(mainArticleAdapter);
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponeModel> call, Throwable t) {

                Log.e("Out",t.toString());
            }
        });
    }


}
