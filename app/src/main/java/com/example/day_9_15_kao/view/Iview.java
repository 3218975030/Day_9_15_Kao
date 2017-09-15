package com.example.day_9_15_kao.view;

import com.example.day_9_15_kao.beans.Json;

import java.util.List;

/**
 * Created by 赵辉 on 2017/9/14.
 */

public interface Iview {
    void error(Exception e);
    void correct(Json json);
}
