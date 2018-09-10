package com.sms.demo.databasedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {

    Context context;
    ArrayList<ObjectCreator> arrayList;
    LayoutInflater inflater;
    TextView name_,phone_,age_;
    public Custom_Adapter(Context context,ArrayList<ObjectCreator> MarrayList) {
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context = this.context;
        arrayList = MarrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.adapter,null);
        name_ = (TextView)view.findViewById(R.id.textView7);
        phone_ = (TextView)view.findViewById(R.id.textView8);
        age_ = (TextView)view.findViewById(R.id.textView9);

        name_.setText(arrayList.get(position).getName_());
        phone_.setText(arrayList.get(position).getPhone());
        age_.setText(Integer.toString(arrayList.get(position).getAge()));

        return view;
    }
}
