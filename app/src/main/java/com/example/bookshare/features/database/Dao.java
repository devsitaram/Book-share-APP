package com.example.bookshare.features.database;

import androidx.room.Delete;
import androidx.room.Update;

import io.reactivex.rxjava3.core.Completable;

@SuppressWarnings("AndroidUnresolvedRoomSqlReference")
@androidx.room.Dao
public interface Dao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public Completable insertAllBook(List<Book> bookList);

//    @Query(value = "Select * From book")
//    Single<List<Book>> getAllBooks();
//
//    @Query("Select * from post where user_id in (:id)")
//    Single<List<UserPojo>> getPostId(String[] id);
//
//    @Query("Select * From post Where user_id Like :Id AND user_name Like :name AND user_email Like :email AND user_phoneNo Like :phoneNo")
//    Single<List<UserPojo>> getUserDetails(int id, String name, String email, String address, String phoneNo);

    @Update
    Completable updateUser(UserPojo postPojo);

    @Delete
    Completable deleteUser(UserPojo postPojo);
}