package com.sitaram.bookshare.features.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@SuppressWarnings("AndroidUnresolvedRoomSqlReference")
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertUser(List<User> userList);

    @Query("Select * FROM user")
    Single<List<User>> getUsers();

    @Query("SELECT EXISTS(SELECT * FROM user WHERE user_name =:nameName AND user_password =:userPassword)")
    boolean loginDetails(String nameName, String userPassword);

}
