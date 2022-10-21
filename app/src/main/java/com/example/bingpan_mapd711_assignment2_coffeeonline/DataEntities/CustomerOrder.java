package com.example.bingpan_mapd711_assignment2_coffeeonline.DataEntities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class CustomerOrder implements Serializable {
    private CoffeeDrink coffeeDrink;
    private String pickupTime = "";

    public CustomerOrder() {
        this.pickupTime = "";
        this.coffeeDrink = null;
    }

    public CustomerOrder(CoffeeDrink coffeeDrink, String pickupTime) {
        this.pickupTime = pickupTime;
        this.coffeeDrink = coffeeDrink;
    }

    protected CustomerOrder(Parcel in) {
        pickupTime = in.readString();
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public CoffeeDrink getCoffeeDrink() {
        return coffeeDrink;
    }

    public void setCoffeeDrink(CoffeeDrink coffeeDrink) {
        this.coffeeDrink = coffeeDrink;
    }


}
