package com.example.day_9_15_kao;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.day_9_15_kao.beans.Json;
import com.example.day_9_15_kao.adepter.MyAdapter;
import com.example.day_9_15_kao.presenter.Presenter;
import com.example.day_9_15_kao.view.Iview;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {

    private ListView lv_list;
    private MyAdapter myAdapter;
    private SwipeRefreshLayout srl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Presenter presenter = new Presenter(this);
        presenter.SendGet("http://v.juhe.cn/weixin/query?key=a332c6b34264527ac142764eaed9364d&pno=1",1);

    }



    private void initView() {
        lv_list = (ListView) findViewById(R.id.lv_list);
        srl = (SwipeRefreshLayout) findViewById(R.id.srl);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srl.setRefreshing(false);

            }
        });
    }


    @Override
    public void error(Exception e) {

    }

    @Override
    public void correct(Json json) {
        Log.e("TAG",json.toString());
    }
}
