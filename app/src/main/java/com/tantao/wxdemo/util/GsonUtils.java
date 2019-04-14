package com.tantao.wxdemo.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：tantao
 * desc : json 解析
 */
public class GsonUtils {
    private static Gson gson = new Gson();

    /**
     *  object 转json
     */
    public static String toJson(Object obj){
        return gson.toJson(obj);
    }

    /**
     *  json 转 object
     */
    public static <T> T fromJson(String json,Class<T> c){
        return gson.fromJson(json,c);
    }

    /**
     *  json 转 List<Object>
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        ArrayList<T> mList = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            mList.add(gson.fromJson(elem, clazz));
        }
        return mList;
    }


}
