package com.example.renkai.login_test;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renkai on 17/7/8.
 */

public class DBManager {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context){
//        dbHelper = new DBHelper(this, "Data.db", context, 1);
        //获取实例化对象
//        db = dbHelper.getWritableDatabase();
    }

    /**
     * add UsersInfo List
     * */
    public void add(List<UsersInfo> usersInfos){
        db.beginTransaction();//开始事务
        for (UsersInfo usersInfo : usersInfos){
            db.execSQL("insert into usertable values(null,?,?)",new Object[]{
                    usersInfo.name,usersInfo.password
            });
        }
        db.setTransactionSuccessful();//设置事务完成
        db.endTransaction();//结束事务
    }

    /**
     * add UserInfo String.etc
     * */
    public void add(String username,String userpassword){
        db.beginTransaction();
        db.execSQL("insert into usertable value(null,?,?)",new Object[]{
                username,userpassword
        });
    }
    /**
     * update info
     **/
    public void update(){

    }

    /**
     * delete previous info
     * 根据age的范围来删除使用者信息
     * */
    public void delete(UsersInfo usersInfo){
        db.delete("usertable","age >= ?",new String[]{String.valueOf(usersInfo.age)});
    }

    /**
     * query all userInfo return list
     * */
    public List<UsersInfo> query(){
        ArrayList<UsersInfo> usersInfos = new ArrayList<>();
        Cursor c  = queryTheCursor();
        while (c.moveToNext()){
            UsersInfo usersInfo = new UsersInfo();
            usersInfo._id = c.getInt(c.getColumnIndex("_id"));
            usersInfo.name = c.getString(c.getColumnIndex("name"));
            usersInfo.password = c.getString(c.getColumnIndex("password"));
            usersInfo.age = c.getInt(c.getColumnIndex("age"));
            usersInfo.info = c.getString(c.getColumnIndex("info"));
            usersInfos.add(usersInfo);
        }
        c.close();
        return usersInfos;
    }

    /**
     * query all userInfo return cursor
     * */
    public Cursor queryTheCursor(){
        Cursor c = db.rawQuery("SELECT * FROM usertable", null);
        return c;
    }

    /**
     * close database
     * */
    public void closeDB(){
        db.close();
    }
}
