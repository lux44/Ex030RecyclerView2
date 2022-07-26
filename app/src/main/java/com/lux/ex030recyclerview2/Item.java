package com.lux.ex030recyclerview2;

public class Item {

    String name;    //"루피"
    String message; //"해적단 선장"
    int profileId;  //R.drawable....
    int imgId;  //R.drawable.bg_one01

    public Item(String name, String message, int profileId, int imgId) {
        this.name = name;
        this.message = message;
        this.profileId = profileId;
        this.imgId = imgId;
    }

    public Item() {
    }
}
