package com.example.bingpan_mapd711_assignment2_coffeeonline.DataEntities;

import java.io.Serializable;

public class CoffeeDrink implements Serializable {
    private String name = "";
    private String size = "";
    private String[] options = null;

    public CoffeeDrink() {
        this.name = "";
        this.size = "";
        this.options = null;
    }

    public CoffeeDrink(String name, String size, String[] options) {
        this.name = name;
        this.size = size;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
