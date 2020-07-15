package com.poolavarone.book2.Model;

public class Person {
    private int id;
    private String category;
    private String name;
    private String Field;
    private String disc;

    private String image1;
    private int fav;

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }


    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }


}
