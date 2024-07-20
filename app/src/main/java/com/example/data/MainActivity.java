package com.example.data;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaring text views
        TextView t1= findViewById(R.id.textView1);
        TextView t2= findViewById(R.id.textView2);
        TextView t3= findViewById(R.id.textView3);
        TextView t4= findViewById(R.id.textView4);

        SQLiteDatabase database = openOrCreateDatabase("crud", MODE_PRIVATE, null);

        database.execSQL("create table if not exists login(Username varchar, Password varchar);");

        database.execSQL("insert into login values('admin','computer');");
        database.execSQL("insert into login values('shivam','123');");

        Cursor result = database.rawQuery("select * from login", null);
        result.moveToFirst();
        String u1=result.getString(0);
        String p1=result.getString(1);
        result.moveToNext();
        String u2=result.getString(0);
        String p2=result.getString(1);
        result.close();

        t1.setText(u1);
        t2.setText(p1);
        t3.setText(u2);
        t4.setText(p2);
    }
}