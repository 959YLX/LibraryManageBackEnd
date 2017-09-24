package com.ylx.librarymanage.controller.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AddItemForm {

    private String type;
    private Integer id;
    private String name;
    private Short classicIndex;
    private Integer inventory;
    private Integer borrowedNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationYear;
    private String publisher;
    private Double price;

    private String ISBN;
    private String editor;
    private Integer pageCount;
    private Long letterCount;

    private String ISSN;
    private String ISDNumber;
    private String subject;
    private Float impactFactor;
    private Short publishingCycle;
    private Short papers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(Long letterCount) {
        this.letterCount = letterCount;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getISDNumber() {
        return ISDNumber;
    }

    public void setISDNumber(String ISDNumber) {
        this.ISDNumber = ISDNumber;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Float getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(Float impactFactor) {
        this.impactFactor = impactFactor;
    }

    public Short getPublishingCycle() {
        return publishingCycle;
    }

    public void setPublishingCycle(Short publishingCycle) {
        this.publishingCycle = publishingCycle;
    }

    public Short getPapers() {
        return papers;
    }

    public void setPapers(Short papers) {
        this.papers = papers;
    }
}
