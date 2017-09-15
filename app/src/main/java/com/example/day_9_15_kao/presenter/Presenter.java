package com.example.day_9_15_kao.presenter;

import android.os.Handler;

import com.example.day_9_15_kao.modle.Iokhttp_utils;
import com.example.day_9_15_kao.beans.Json;
import com.example.day_9_15_kao.modle.OkHttpUtils;
import com.example.day_9_15_kao.view.Iview;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by 赵辉 on 2017/9/14.
 */

public class Presenter {
    Iview iview;
    OkHttpUtils okHttpUtils;
    public Presenter(Iview iview) {
        this.iview = iview;
        okHttpUtils=new OkHttpUtils();
    }
    public void SendGet(String url,int page){
        okHttpUtils.login(url, page, new Iokhttp_utils() {
            @Override
            public void error(Exception e) {
                iview.error(e);
            }

            @Override
            public void correct(Json json) {
            iview.correct(json);
            }
        });
    }
}
