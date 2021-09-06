package com.example.androidlabaptech1;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Product> listProduct;

    public ProductAdapter(Activity activity, List<Product> listProduct){
        this.activity = activity;
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = activity.getLayoutInflater().inflate(R.layout.product_item, parent, false);
       ProductHolder holder = new ProductHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHolder productHolder = (ProductHolder) holder;
        Product model = listProduct.get(position);
        productHolder.ivCover.setImageResource(model.getImage());
        productHolder.tvName.setText(model.getName());
        productHolder.tvPrice.setText(model.getPrice());
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public  class ProductHolder extends RecyclerView.ViewHolder{
        ImageView ivCover;
        TextView tvName;
        TextView tvPrice;

        public ProductHolder(@NonNull View interView){
            super(interView);
            ivCover =interView.findViewById(R.id.imgCover);
            tvName = interView.findViewById(R.id.tvName);
            tvPrice = interView.findViewById(R.id.tvPrice);
        }
    }
}
