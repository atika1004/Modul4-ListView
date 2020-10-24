package com.example.listpahlawan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PahlawanAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pahlawan> heroes = new ArrayList<>();

    public void setHeroes(ArrayList<Pahlawan> heroes) {
        this.heroes = heroes;
    }

    public PahlawanAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_pahlawan, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);

        Pahlawan pahlawan = (Pahlawan) getItem(i);
        viewHolder.bind(pahlawan);
        return itemView;
    }

    private static class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private CircleImageView imgPhoto;
        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Pahlawan pahlawan) {
            txtName.setText(pahlawan.getName());
            txtDescription.setText(pahlawan.getDescription());
            imgPhoto.setImageResource(pahlawan.getPhoto());

        }
    }
}