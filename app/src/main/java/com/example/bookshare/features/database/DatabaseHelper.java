package com.example.bookshare.features.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = UserPojo.class, exportSchema = false, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "login_db";
    private static DatabaseHelper instance;

    // this methods are FIFO data
    public static synchronized DatabaseHelper getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context, DatabaseHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return  instance;
    }

    public  abstract  Dao loginDao();
}
