package com.example.bookshare.features.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
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

    @ColumnInfo(name = "user_password")
    public String password;

    public UserPojo(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
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
