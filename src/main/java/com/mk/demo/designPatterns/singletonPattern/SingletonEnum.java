package com.mk.demo.designPatterns.singletonPattern;

/**
 * @author Mckay
 * @create 2020-10-02
 * @description
 **/
public class SingletonEnum {


    public static void main(String[] args) {

        Country instance = Country.getInstance(1);
        System.out.println(instance);
    }
}

enum Singleton01 {
    INSTANCE;

    public void sayOk() {
        System.out.println("ok");
    }
}

enum Country {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕");
    private Integer retCode;
    private String resMessage;

    Country(Integer retCode, String resMessage) {
        this.retCode = retCode;
        this.resMessage = resMessage;
    }

    @Override
    public String toString() {
        return "Country{" +
                "retCode=" + retCode +
                ", resMessage='" + resMessage + '\'' +
                '}';
    }

    public static Country getInstance(int index) {
        for (Country value : Country.values()) {
            if (index == value.retCode) {
                return value;
            }
        }
        return null;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }
}
