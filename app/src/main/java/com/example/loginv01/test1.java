package com.example.loginv01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class test1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
    }
    public void CreateDB(View view) {
        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
        //datebase 文件的创建靠下面这句话
        SQLiteDatabase readableDatabase = helper.getReadableDatabase();
    }

    public void insert(View view)
    {
        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
        //datebase 文件的创建靠下面这句话
        SQLiteDatabase db = helper.getWritableDatabase();

        if(db.isOpen())
        {
            //String sql = "insert into ac_pw " + "(accout,password)values(ac,pw)";
            String sql = "insert into ac_pw(accout) values('张三')";
            db.execSQL(sql);
        }
        db.close();
    }

    public void query(View view)
    {
        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
        //datebase 文件的创建靠下面这句话
        SQLiteDatabase db = helper.getReadableDatabase();
        if(db.isOpen())
        {
            Cursor cursor = db.rawQuery("select * from ac_pw",null);
            while(cursor.moveToNext())
            {
                @SuppressLint("Range") int _id = cursor.getInt(cursor.getColumnIndex("_id"));
                @SuppressLint("Range") String ac = cursor.getString(cursor.getColumnIndex("accout"));

                Log.d("嗯嗯","query: _id:"+_id + "accout"+ ac);
            }
            //String sql = "insert into ac_pw " + "(accout,password)values(ac,pw)";
            //String sql = "insert into ac_pw(accout) values('张三')";
            cursor.close();
        }
        db.close();

    }
}