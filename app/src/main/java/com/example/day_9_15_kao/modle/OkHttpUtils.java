package com.example.day_9_15_kao.modle;

import android.os.Handler;

import com.example.day_9_15_kao.beans.Json;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 赵辉 on 2017/9/14.
 */

public class OkHttpUtils implements IModel{
    private Handler handler=new Handler();
    private OkHttpClient client = new OkHttpClient();

    @Override
    public void login(String url, int page, final Iokhttp_utils iokhttp_utils) {
         Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        iokhttp_utils.error(e);
                    }
                },500);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
              handler.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      Gson gson = new Gson();
                      Json json = gson.fromJson(string, Json.class);
                        iokhttp_utils.correct(json);
                  }
              },500);
            }
        });
    }
}
