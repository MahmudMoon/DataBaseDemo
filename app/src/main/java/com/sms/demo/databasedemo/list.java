package com.sms.demo.databasedemo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class list extends AppCompatActivity {
    ArrayList<ObjectCreator> detaShow;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        detaShow = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list);

        SqlHelper sqlHelper = new SqlHelper(getApplicationContext());
        Cursor retrived = sqlHelper.retrive();
        if (retrived.getCount() > 0) {
            retrived.moveToFirst();
            for (int i = 0; i < retrived.getCount(); i++) {
                String name = retrived.getString(0);
                String phone = retrived.getString(1);
                int age = retrived.getInt(2);
                retrived.moveToNext();
                detaShow.add(new ObjectCreator(name, phone, age));
                // Log.d(Tag, "Name : " + name + "\nPhone : " + phone + "\nAge : "+ Integer.toString(age));
            }


            Custom_Adapter custom_adapter = new Custom_Adapter(getApplicationContext(), detaShow);
            listView.setAdapter(custom_adapter);

        }
    }
}
