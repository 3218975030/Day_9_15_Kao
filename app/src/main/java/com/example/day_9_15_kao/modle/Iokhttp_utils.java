package com.example.day_9_15_kao.modle;

import com.example.day_9_15_kao.beans.Json;

/**
 * Created by 赵辉 on 2017/9/14.
 */

public interface Iokhttp_utils {
    void error(Exception e);
    void correct(Json json);
}
