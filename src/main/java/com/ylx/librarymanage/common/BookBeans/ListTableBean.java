package com.ylx.librarymanage.common.BookBeans;

public class ListTableBean {

    private String id;

    private String name;

    private String classic;

    private String inventory;

    private String borrowed;

    private String year;

    private String publisher;

    private Double price;

    public ListTableBean() {
    }

    public ListTableBean(String id, String name, String classic, String inventory, String borrowed, String year, String publisher, Double price) {
        this.id = id;
        this.name = name;
        this.classic = classic;
        this.inventory = inventory;
        this.borrowed = borrowed;
        this.year = year;
        this.publisher = publisher;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassic() {
        return classic;
    }

    public void setClassic(String classic) {
        this.classic = classic;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
