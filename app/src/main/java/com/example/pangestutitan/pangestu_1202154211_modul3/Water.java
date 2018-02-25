package com.example.pangestutitan.pangestu_1202154211_modul3;

/**
 * Created by Pangestu Titan on 2/25/2018.
 */

public class Water {

    private  String title;
    private String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "ImageResource";


    public Water(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }
    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }

}


