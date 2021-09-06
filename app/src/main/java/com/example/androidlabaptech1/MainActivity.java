package com.example.androidlabaptech1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        ProductAdapter adapter = new ProductAdapter(this, listProduct);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        RecyclerView rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);
    }

    private void initData() {
        listProduct.add(new Product("Product1", "100000", R.drawable.img_3));
        listProduct.add(new Product("Product2", "200000", R.drawable.img_3));
        listProduct.add(new Product("Product3", "120000", R.drawable.img_3));
        listProduct.add(new Product("Product4", "150000", R.drawable.img_3));
        listProduct.add(new Product("Product5", "190000", R.drawable.img_3));

    }
}