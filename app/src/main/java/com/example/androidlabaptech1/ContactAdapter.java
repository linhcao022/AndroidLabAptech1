package com.example.androidlabaptech1;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<ContactModel> listContacts;
    private Context mContext;
    private IOnChildItemClick iOnChildItemClick;

    public ContactAdapter(List<ContactModel> listContacts, Context mContext) {
        this.listContacts = listContacts;
        this.mContext = mContext;
    }

    public void registerChildItemClick(IOnChildItemClick iOnChildItemClick) {
        this.iOnChildItemClick = iOnChildItemClick;
    }

    public void unRegisterChildItemClick() {
        this.iOnChildItemClick = null;
    }

    @Override
    public int getCount() {
        return listContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View rowView = convertView;
        // reuse views
        if(rowView == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_contact, null);

            // configure view holder
            ViewHolder holder = new ViewHolder();
            holder.tvName =(TextView) rowView.findViewById((R.id.tvName));
            holder.tvPhone = (TextView) rowView.findViewById(R.id.tvPhone);
            holder.ivAvatar =(ImageView) rowView.findViewById(R.id.ivAvatar);
            holder.btCall = (Button) rowView.findViewById(R.id.btCall);
            holder.btEdit = (Button) rowView.findViewById(R.id.btEdit);
            rowView.setTag(holder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.tvName.setText(listContacts.get(i).getName());
        holder.tvPhone.setText(listContacts.get(i).getPhone());
        holder.ivAvatar.setImageResource(listContacts.get(i).getImage());

        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(i);
            }
        });
        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnChildItemClick.onItemChildClick(i);
            }
        });
        return convertView;
    }

    private void onCall(int position){
        ContactModel contact = listContacts.get(position);
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+contact.getPhone()));
        if(ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

        }
        mContext.startActivities(intent);
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
        Button btCall;
        Button btEdit;
    }
}
