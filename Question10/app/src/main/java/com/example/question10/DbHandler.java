package com.example.question10;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class DbHandler extends  SQLiteOpenHelper {
    public DbHandler(@Nullable Context context, @Nullable String name,
                     @Nullable SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String query = "create table student (id primary key ,name text,course text)";
        String query = "create table user(name text,email text,password text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String drop = String.valueOf("drop table if exists");
        db.execSQL(drop,new String[]{"user"});
        onCreate(db);
    }
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values=  new ContentValues();

        values.put("name",user.getName());
        values.put("email",user.getEmail());
        values.put("password",user.getPassword());

        long k = db.insert("user",null,values);

//        Log.d("addTag", Long.toString(k));
        db.close();
    }
    public List<User> getAllUsers(){
        List<User> res = new ArrayList<>();

        String selectQuery = "SELECT  * FROM user " ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        System.out.println(selectQuery);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setName(cursor.getString(0));
                user.setEmail(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                res.add(user);
            } while (cursor.moveToNext());
            // --------------------
//            Log.d("Student obj : ",res.toString());
        }
        return res;
    }



}
