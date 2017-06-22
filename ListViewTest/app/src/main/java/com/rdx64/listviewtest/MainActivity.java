package com.rdx64.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //    private String[] data = {
//            "Apple", "Banana", "Orange", "Watermelon",
//            "Pear", "Grape", "Pineapple", "Strawberry",
//            "Cherry", "Mango", "Apple", "Banana",
//            "Orange", "Watermelon", "Pear", "Grape",
//            "Pineapple", "Strawberry", "Cherry", "Mango"
//    };
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this, android.R.layout.simple_list_item_1, data
//        );
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
        initFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                if (fruit != null) {
                    Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Orange", R.drawable.orange_pic));
            fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
            fruitList.add(new Fruit("Pear", R.drawable.pear_pic));
            fruitList.add(new Fruit("Grape", R.drawable.grape_pic));
            fruitList.add(new Fruit("Pineapple", R.drawable.pineapple_pic));
            fruitList.add(new Fruit("Strawberry", R.drawable.strawberry_pic));
            fruitList.add(new Fruit("Cherry", R.drawable.cherry_pic));
            fruitList.add(new Fruit("Mango", R.drawable.mango_pic));
        }
    }

}
