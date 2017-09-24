package com.ylx.librarymanage.model;

import java.util.Date;

public class Basic {
    private Integer uid;

    private Integer id;

    private Short type;

    private String name;

    private Short classicIndex;

    private Integer inventory;

    private Integer borrowedNumber;

    private Date publicationYear;

    private String publisher;

    private Double price;

    private Date updateTime;

    private Date createTime;

    private Boolean trash;

    public Basic() {
    }

    public Basic(Integer uid, Integer id, Short type, String name, Short classicIndex, Integer inventory, Integer borrowedNumber, Date publicationYear, String publisher, Double price, Date updateTime, Date createTime, Boolean trash) {
        this.uid = uid;
        this.id = id;
        this.type = type;
        this.name = name;
        this.classicIndex = classicIndex;
        this.inventory = inventory;
        this.borrowedNumber = borrowedNumber;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.price = price;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.trash = trash;
    }

    public Basic(Integer id, String name, Short classicIndex, Integer inventory, Integer borrowedNumber, Date publicationYear, String publisher, Double price, Boolean trash) {
        this.id = id;
        this.name = name;
        this.classicIndex = classicIndex;
        this.inventory = inventory;
        this.borrowedNumber = borrowedNumber;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.price = price;
        this.trash = trash;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getClassicIndex() {
        return classicIndex;
    }

    public void setClassicIndex(Short classicIndex) {
        this.classicIndex = classicIndex;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getBorrowedNumber() {
        return borrowedNumber;
    }

    public void setBorrowedNumber(Integer borrowedNumber) {
        this.borrowedNumber = borrowedNumber;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getTrash() {
        return trash;
    }

    public void setTrash(Boolean trash) {
        this.trash = trash;
    }
}