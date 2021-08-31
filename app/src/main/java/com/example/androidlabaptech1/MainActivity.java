package com.example.androidlabaptech1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ContactModel> listContacts = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this, listContacts);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel contactModel = listContacts.get(i);
                Toast.makeText(MainActivity.this, contactModel.getName()+ contactModel.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initView() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    public void onItemChildClick(int position){
        ContactModel contact = listContacts.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}