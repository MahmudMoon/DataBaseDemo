package com.sms.demo.databasedemo;

public class ObjectCreator {
    String name_;
    String Phone;
    int age;


    public ObjectCreator() {

    }

    public ObjectCreator(String name_, String phone, int age) {
        this.name_ = name_;
        Phone = phone;
        this.age = age;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
