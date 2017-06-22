package com.rdx64.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 3);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    //    private void initFruits() {
//        for (int i = 0; i < 2; i++) {
//            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
//            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
//            fruitList.add(new Fruit("Orange", R.drawable.orange_pic));
//            fruitList.add(new Fruit("Watermelon", R.drawable.watermelon_pic));
//            fruitList.add(new Fruit("Pear", R.drawable.pear_pic));
//            fruitList.add(new Fruit("Grape", R.drawable.grape_pic));
//            fruitList.add(new Fruit("Pineapple", R.drawable.pineapple_pic));
//            fruitList.add(new Fruit("Strawberry", R.drawable.strawberry_pic));
//            fruitList.add(new Fruit("Cherry", R.drawable.cherry_pic));
//            fruitList.add(new Fruit("Mango", R.drawable.mango_pic));
//        }
//    }
    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            fruitList.add(new Fruit(getRandomlengthName("Apple"), R.drawable.apple_pic));
            fruitList.add(new Fruit(getRandomlengthName("Banana"), R.drawable.banana_pic));
            fruitList.add(new Fruit(getRandomlengthName("Orange"), R.drawable.orange_pic));
            fruitList.add(new Fruit(getRandomlengthName("Watermelon"), R.drawable.watermelon_pic));
            fruitList.add(new Fruit(getRandomlengthName("Pear"), R.drawable.pear_pic));
            fruitList.add(new Fruit(getRandomlengthName("Grape"), R.drawable.grape_pic));
            fruitList.add(new Fruit(getRandomlengthName("Pineapple"), R.drawable.pineapple_pic));
            fruitList.add(new Fruit(getRandomlengthName("Strawberry"), R.drawable.strawberry_pic));
            fruitList.add(new Fruit(getRandomlengthName("Cherry"), R.drawable.cherry_pic));
            fruitList.add(new Fruit(getRandomlengthName("Mango"), R.drawable.mango_pic));
        }
    }

    private String getRandomlengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }
}
