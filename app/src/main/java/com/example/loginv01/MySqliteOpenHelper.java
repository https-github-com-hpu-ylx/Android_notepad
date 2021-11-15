package com.example.loginv01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqliteOpenHelper extends SQLiteOpenHelper {
    private static SQLiteOpenHelper mInstance;
    public static synchronized SQLiteOpenHelper getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = new MySqliteOpenHelper(context,"mess.db",null,1);
        }
        return mInstance;

    }

    public MySqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //数据库实例化，如果已经创建，则补再创建。
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_mess = "create table ac_pw(_id integer primary key autoincrement, accout text,password text)";
        db.execSQL(sql_mess);
        String sql_nr = "create table con(_id integer primary key autoincrement, title text,time text, content text)";
        db.execSQL(sql_nr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
