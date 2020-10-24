package com.example.listpahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PahlawanAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private ArrayList<Pahlawan> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv_list);
        adapter = new PahlawanAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        prepare();
        addItem();
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        heroes = new ArrayList<>();
        for (int i = 0;i < dataName.length;i++) {
            Pahlawan pahlawan = new Pahlawan();
            pahlawan.setPhoto(dataPhoto.getResourceId(i, -1));
            pahlawan.setName(dataName[i]);
            pahlawan.setDescription(dataDescription[i]);
            heroes.add(pahlawan);
        }
        adapter.setHeroes(heroes);
    }
}