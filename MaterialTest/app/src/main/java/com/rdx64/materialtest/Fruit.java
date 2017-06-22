package com.rdx64.materialtest;

/**
 * Created by RDX64 on 2017/6/18.
 */

public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String _name, int _imageId) {
        this.name = _name;
        this.imageId = _imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
