package com.example.nathapong.getnesteddatafromfirebase;


public class AddMenu {

    private String name;
    private String description;
    private String image;
    private int price;

    public AddMenu() {}

    public AddMenu(String name, String description, String image, int price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }
}
