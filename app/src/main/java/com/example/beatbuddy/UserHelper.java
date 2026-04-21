package com.example.beatbuddy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserHelper extends SQLiteOpenHelper {
    public UserHelper(@Nullable Context context) {
        super(context, "usersDB.db",null,1);
    }

    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create TABLE usersDB(email TEXT,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usersDB");
    }

    public boolean insertUser(String email,String passwd)
    {
        SQLiteDatabase sqdb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("email",email);
        cv.put("password",passwd);
        long l=sqdb.insert("usersDB",null,cv);
        if(l==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean getCredentials(String f1,String f2)
    {
        SQLiteDatabase sqdb=this.getWritableDatabase();
        String[] args={f1,f2};
        Cursor cus=sqdb.rawQuery("SELECT *FROM usersDB WHERE email=? and password=?",args);
        boolean exists=cus.moveToFirst();
        cus.close();
        return exists;
    }
}
