package com.example.bookshare.features.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@SuppressWarnings("AndroidUnresolvedRoomSqlReference")
@androidx.room.Dao
public interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertUser(List<UserPojo> userPojoList);

    @Query("Select * from user")
    Single<List<UserPojo>> getAllUserDetails();
//
//    @Query("Select * from post where user_id in (:id)")
//    Single<List<UserPojo>> getPostId(String[] id);
//
//    @Query("Select * From post Where user_name Like :name AND user_password Like :password")
//    Single<List<UserPojo>> getUserLoginDetails(String name, String password);

    @Update
    Completable updateUser(UserPojo postPojo);

    @Delete
    Completable deleteUser(UserPojo postPojo);
}