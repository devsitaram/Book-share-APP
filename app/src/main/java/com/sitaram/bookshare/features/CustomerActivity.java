package com.sitaram.bookshare.features;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.example.bookshare.R;
import com.sitaram.bookshare.features.database.DatabaseHelper;
import com.sitaram.bookshare.features.database.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CustomerActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        databaseHelper = DatabaseHelper.getInstance(this);
        insertStudents()
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        compositeDisposable.add(disposable);
                    }

                    @Override
                    public void onComplete() {
                        setRecyclerView();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }

    /**
     * create a insertStudents methods
     * create an object of arraylist which is student class types of list
     * add the new student data where call the constructor
     * return the abstract databases class's abstract studentDao method's insertAll method which accept the student list
     */
    private Completable insertStudents() {
        userList = new ArrayList<>();
        userList.add(new User("ram1010@gmail.com", "Manoj Thapa", "manoj123"));
        userList.add(new User( "manjil5555@gmail.com", "Sitaram Thing", "sitaram0001"));
        userList.add(new User("sitaram1111@gmail.com", "Aman Giri", "giri111"));
        Log.d("List of User ",":"+userList);
        return databaseHelper.userDao().insertUser(userList);
    }

    @SuppressLint("CheckResult")
    private void setRecyclerView() {
        getUserData()
                .subscribeOn(Schedulers.io())
                .subscribe((List<User> students) -> {
                    ArrayList<User> usersList = new ArrayList<>();
                    for (User user: usersList) {
                        Log.d("All the List :", "Data" + user);
                    }
                });
    }

    private Single<List<User>> getUserData(){
        return databaseHelper.userDao().getUserDetails();
    }
}