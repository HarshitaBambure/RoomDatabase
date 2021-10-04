package com.example.roomdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EntryDetails")
public class EntryDetails {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String country;
    private String address;

    public EntryDetails(String name, String email, String mobile, String country, String address) {
        //this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.country = country;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}



