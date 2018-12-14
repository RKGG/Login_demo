package com.example.renkai.login_test;

/**
 * Created by renkai on 17/7/8.
 */

public class UsersInfo {
    public int _id;
    public String name;
    public String password;
    public int age;
    public String info;

    public UsersInfo(){

    }

    public UsersInfo(String name){
        this.name = name;
    }
    public UsersInfo(String name,String password){
        this.name = name;
        this.password = password;
    }

    public UsersInfo(String name,int age,String info){
        this.name = name;
        this.age = age;
        this.info = info;
    }
    public UsersInfo(String name,String password,int age,String info){
        this.name = name;
        this.password = password;
        this.age = age;
        this.info = info;
    }


}
