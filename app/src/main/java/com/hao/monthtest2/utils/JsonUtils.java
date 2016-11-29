package com.hao.monthtest2.utils;

import com.google.gson.Gson;
import com.hao.monthtest2.bean.Bean1;
import com.hao.monthtest2.bean.Bean2;
import com.hao.monthtest2.bean.Bean3;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-11-27.
 */

public class JsonUtils {
    public static ArrayList<Bean3> parseJson(String json) {
        Gson gson = new Gson();
        Bean1 bean1=gson.fromJson(json, Bean1.class);
        Bean2 bean2=bean1.getData();
        ArrayList<Bean3> list=bean2.getZhuanList();
        return list;
    }

}
