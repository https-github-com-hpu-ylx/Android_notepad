package com.example.loginv01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class regeisteActiivity extends AppCompatActivity {

    private Button btn;
    private EditText ac,pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regeiste);

        //更改状态栏背景颜色
        Change_color.translucentStatusBar(regeisteActiivity.this,false);
        //改变状态栏字体颜色
        Change_color.setAndroidNativeLightStatusBar(regeisteActiivity.this,true);

        btn = (Button) findViewById(R.id.btn_regist);    //查找控件
        ac = (EditText) findViewById(R.id.regist_accout);
        pw = (EditText) findViewById(R.id.regist_pw);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String accout = ac.getText().toString().trim();
                String password = pw.getText().toString().trim();
                if(accout.equals("") || password.equals(""))
                {
                    Toast toast = Toast.makeText(regeisteActiivity.this,"请输入账号或密码",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, 200, 500);//设置位置
                    toast.show();//弹出提示
                }
                else
                {
                    DB_ac.insert(regeisteActiivity.this,accout,password);
                    Toast toast = Toast.makeText(regeisteActiivity.this,"注册成功，请登录。奥利给！",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, 200, 500);//设置位置
                    toast.show();//弹出提示
                    //跳转回登录界面
                    //insert(ac,pw);
                    Intent intent = new Intent(regeisteActiivity.this, MainActivity.class);   //创建
                    startActivity(intent);
                }

            }
        });
    }

//    public void insert(String accout,String password)
//    {
//        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
//        //datebase 文件的创建靠下面这句话
//        SQLiteDatabase db = helper.getWritableDatabase();
//
//        if(db.isOpen())
//        {
//            String sql = "insert into ac_pw" + "(accout,password)values('" + accout + "','" + password + "')";
//            //String sql = "insert into ac_pw(accout) values('张三')";
//            db.execSQL(sql);
//        }
//        db.close();
//    }

//    public void query()
//    {
//        SQLiteOpenHelper helper = MySqliteOpenHelper.getInstance(this);
//        //datebase 文件的创建靠下面这句话
//        SQLiteDatabase db = helper.getReadableDatabase();
//        if(db.isOpen())
//        {
//            Cursor cursor = db.rawQuery("select * from ac_pw",null);
//            while(cursor.moveToNext())
//            {
//                @SuppressLint("Range") int _id = cursor.getInt(cursor.getColumnIndex("_id"));
//                @SuppressLint("Range") String ac = cursor.getString(cursor.getColumnIndex("accout"));
//
//                Log.d("嗯嗯","query: _id:"+_id + "accout"+ ac);
//            }
//            //String sql = "insert into ac_pw " + "(accout,password)values(ac,pw)";
//            //String sql = "insert into ac_pw(accout) values('张三')";
//            cursor.close();
//        }
//        db.close();
//    }
}