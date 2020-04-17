package com.example.mobilproje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Main6Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<UserListModel> usersList;
    Users usersClass = new Users();
    String [][] users;
    int i;
    int [][] usersImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        users = usersClass.users;
        usersImage = usersClass.usersImage;

        recyclerView = findViewById(R.id.recycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        usersList = new ArrayList<>();

        i = 0;
        while (i< users.length){
            usersList.add(new UserListModel(usersImage[i][1], users[i][0], users[i][1]));
            i++;
        }

        UserListAdapter adapter = new UserListAdapter(usersList);
        recyclerView.setAdapter(adapter);

    }
}
