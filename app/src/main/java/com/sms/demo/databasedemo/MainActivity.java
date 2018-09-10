package com.sms.demo.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_phone,et_age;
    TextView tv_name,tv_phone,tv_age;

    Button btn_Add,btn_Read,btn_Update,btn_Delete;
    int age;
    String name_,phone_;
    ObjectCreator objectCreator;
    ArrayList<ObjectCreator> UserDetail;
    SqlHelper sqlHelper;
    private String Tag = "DataBaseResult";

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_views();
        init_variables();
        init_listener();
        init_functions();

    }

    private void init_views() {
        et_name = (EditText)findViewById(R.id.editText);
        et_phone = (EditText)findViewById(R.id.editText2);
        et_age = (EditText)findViewById(R.id.editText3);

        btn_Add = (Button)findViewById(R.id.button);
        btn_Read = (Button)findViewById(R.id.button2);
        btn_Update = (Button)findViewById(R.id.button3);
        btn_Delete =(Button)findViewById(R.id.button4);
        listView = (ListView)findViewById(R.id.list);
    }

    private void init_variables() {
          UserDetail = new ArrayList<>();
          sqlHelper = new SqlHelper(this);

    }

    private void init_listener() {


        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 name_ = et_name.getText().toString();
                 age = Integer.parseInt(et_age.getText().toString());
                 phone_ = et_phone.getText().toString();

                 objectCreator = new ObjectCreator(name_,phone_,age);
                boolean inserted = sqlHelper.insert(objectCreator);
                if(inserted)
                    Toast.makeText(getApplicationContext(),"OKK",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Not OKK",Toast.LENGTH_SHORT).show();
                //UserDetail.add(objectCreator);

            }
        });

        btn_Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,list.class);
                startActivity(intent);
            }
        });

        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_,phone_;
                int age;
                name_ = et_name.getText().toString();
                phone_ = et_phone.getText().toString();
                age = Integer.parseInt(et_age.getText().toString());
                int res = sqlHelper.update(name_,phone_,age);
                if(res>0){
                    Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getApplicationContext(),"Failed to update",Toast.LENGTH_SHORT).show();
            }
        });

        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone_ = et_phone.getText().toString();
                int isdeleted = sqlHelper.delete(phone_);
                if(isdeleted>0){
                    Toast.makeText(getApplicationContext(),"DEleted",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getApplicationContext(),"Could not be deleted",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void init_functions() {

    }
}
