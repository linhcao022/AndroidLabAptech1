package com.example.androidlabaptech1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<ContactModel> listContacts;
    private Activity activity;

    public ContactAdapter(List<ContactModel> listContacts, Activity activity) {
        this.listContacts = listContacts;
        this.activity = activity;
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
        if(convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_contact, viewGroup, false);
            ViewHolder holder = new ViewHolder();
            holder.tvName =(TextView) convertView.findViewById((R.id.tvName));
            holder.tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            holder.ivAvatar =(ImageView) convertView.findViewById(R.id.ivAvatar);
            convertView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();
        ContactModel model = listContacts.get(i);
        holder.tvName.setText(model.getName());
        holder.tvPhone.setText(model.getPhone());
        holder.ivAvatar.setImageResource(model.getImage());
        return convertView;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
    }
}
