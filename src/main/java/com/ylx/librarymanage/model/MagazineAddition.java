package com.ylx.librarymanage.model;

import java.util.Date;

public class MagazineAddition {
    private Integer uid;

    private Integer id;

    private String issn;

    private String isdNumber;

    private String subject;

    private Float impactFactor;

    private Short publishingCycle;

    private Short papers;

    private Double averagePaperPrice;

    private Date updateTime;

    private Date createTime;

    public MagazineAddition(Integer uid, Integer id, String issn, String isdNumber, String subject, Float impactFactor, Short publishingCycle, Short papers, Double averagePaperPrice, Date updateTime, Date createTime) {
        this.uid = uid;
        this.id = id;
        this.issn = issn;
        this.isdNumber = isdNumber;
        this.subject = subject;
        this.impactFactor = impactFactor;
        this.publishingCycle = publishingCycle;
        this.papers = papers;
        this.averagePaperPrice = averagePaperPrice;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public MagazineAddition() {
        super();
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

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn == null ? null : issn.trim();
    }

    public String getIsdNumber() {
        return isdNumber;
    }

    public void setIsdNumber(String isdNumber) {
        this.isdNumber = isdNumber == null ? null : isdNumber.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
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

    public Double getAveragePaperPrice() {
        return averagePaperPrice;
    }

    public void setAveragePaperPrice(Double averagePaperPrice) {
        this.averagePaperPrice = averagePaperPrice;
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
}