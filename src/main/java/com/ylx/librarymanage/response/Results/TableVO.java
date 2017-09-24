package com.ylx.librarymanage.response.Results;

public class TableVO {

    private Integer id;

    private String name;

    private Short classIndex;

    private Integer inventory;

    private Integer borrowed;

    private String publishTime;

    private String publisher;

    private Double price;

    public TableVO(Integer id, String name, Short classIndex, Integer inventory, Integer borrowed, String publishTime, String publisher, Double price) {
        this.id = id;
        this.name = name;
        this.classIndex = classIndex;
        this.inventory = inventory;
        this.borrowed = borrowed;
        this.publishTime = publishTime;
        this.publisher = publisher;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Short getClassIndex() {
        return classIndex;
    }

    public Integer getInventory() {
        return inventory;
    }

    public Integer getBorrowed() {
        return borrowed;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public String getPublisher() {
        return publisher;
    }

    public Double getPrice() {
        return price;
    }
}
