package com.example.nathapong.getnesteddatafromfirebase;

public class Restaurants {

    private String name;
    private String address;
    private Location location;
    private Menu menu;

    public Restaurants() {}

    public Restaurants(String name, String address, Location location, Menu menu) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.menu = menu;
    }

    public String getName() {return name;}

    public String getAddress() {return address;}

    public Location getLocation() {return location;}

    public Menu getMenu() {return menu;}
}

 class Location {

     private double latitude;
     private double longitude;

     public Location() {}

     public Location(double latitude, double longitude) {
         this.latitude = latitude;
         this.longitude = longitude;
     }

     public double getLatitude() {return latitude;}

     public double getLongitude() {return longitude;}
 }

 class Menu {
     private Steak steak;

     public Menu() {}

     public Menu(Steak steak) {
         this.steak = steak;
     }

     public Steak getSteak() {return steak;}
 }

 class Steak {
     private Beef beef;
     private Pork pork;

     public Steak() {}

     public Steak(Beef beef, Pork pork) {
         this.beef = beef;
         this.pork = pork;
     }

     public Beef getBeef() {return beef;}

     public Pork getPork() {return pork;}
 }

 class Beef {
    private String name;
    private String description;
    private String image;
    private int price;

     public Beef() {}

     public Beef(String name, String description, String image, int price) {
         this.name = name;
         this.description = description;
         this.image = image;
         this.price = price;
     }

     public String getName() {return name;}

     public String getDescription() {return description;}

     public String getImage() {return image;}

     public int getPrice() {return price;}
 }

 class Pork {
     private String name;
     private String description;
     private String image;
     private int price;

     public Pork() {}

     public Pork(String name, String description, String image, int price) {
         this.name = name;
         this.description = description;
         this.image = image;
         this.price = price;
     }

     public String getName() {return name;}

     public String getDescription() {return description;}

     public String getImage() {return image;}

     public int getPrice() {return price;}
 }


