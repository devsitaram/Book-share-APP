package com.example.bookshare.features.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "post")
public class UserPojo {
    @PrimaryKey
    @ColumnInfo(name="user_id")
    public int id;
    @ColumnInfo(name = "user_name")
    public String name;
    @ColumnInfo(name = "user_email")
    public String email;
    @ColumnInfo(name = "user_address")
    public String address;
    @ColumnInfo(name = "user_phoneNo")
    public String phoneNo;

    public UserPojo(int id, String name, String email, String address, String phoneNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNo = phoneNo;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phoneNo;
    }

    public void setPhone(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
