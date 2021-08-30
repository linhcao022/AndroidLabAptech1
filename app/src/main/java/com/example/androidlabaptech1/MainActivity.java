package com.example.androidlabaptech1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContacts, this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel contactModel = listContacts.get(i);
                Toast.makeText(MainActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initData() {
        ContactModel contact = new ContactModel("Name1", "09812379873", R.drawable.img);
        listContacts.add(contact);
        contact = new ContactModel("Name2", "01012379873", R.drawable.img_1);
        listContacts.add(contact);
        contact = new ContactModel("Name3", "09812371873", R.drawable.img_2);
        listContacts.add(contact);
        contact = new ContactModel("Name4", "09812379823", R.drawable.img_3);
        listContacts.add(contact);

    }
}