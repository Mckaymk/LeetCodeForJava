package com.mk.demo.json;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Mckay
 * @create 2020-10-17
 * @description
 **/

public class Test {
    public Person getPerson() {
        return new Person("张三", "男", 25);
    }



    public void EntityToJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", getPerson().getName());
        jsonObject.put("sex", getPerson().getSex());
        jsonObject.put("age", getPerson().getAge());
        System.out.println(jsonObject.toString());
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
