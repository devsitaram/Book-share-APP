package com.sitaram.bookshare.features.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserPojo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    public int id;
    @ColumnInfo(name = "user_email")
    public String email;

    @ColumnInfo(name = "user_name")
    public String name;
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
}
