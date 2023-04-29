package com.sitaram.bookshare.features.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@SuppressWarnings("AndroidUnresolvedRoomSqlReference")
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertUser(List<User> userList);

    @Query("Select * from user")
    Single<List<User>> getUserDetails();

    @Query("Select * From user Where user_name Like :nameName AND user_password Like :userPassword")
    Single<User> getLoginDetails(String nameName, String userPassword);

    @Update
    Completable updateUser(User postPojo);

    @Delete
    Completable deleteUser(User postPojo);
}
