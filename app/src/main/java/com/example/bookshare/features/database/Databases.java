package com.example.bookshare.features.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = UserPojo.class, version = 1)
public abstract class Databases extends RoomDatabase {
    public static Databases instance;
    private static final String DB_NAME = "UserDatabase";

    public static synchronized Databases getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context, Databases.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    // create the abstract methods
    public abstract Dao dao();

}
