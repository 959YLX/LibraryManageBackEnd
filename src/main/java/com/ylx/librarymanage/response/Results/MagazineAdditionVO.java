package com.ylx.librarymanage.response.Results;

import com.ylx.librarymanage.common.Const;

public class MagazineAdditionVO {

    private String type = Const.MAGAZINE_TYPE;

    private String ISSN;

    private String index;

    private String subject;

    private Float impactFactor;

    private Short cycle;

    private Short papers;

    private Double price;

    public MagazineAdditionVO(String ISSN, String index, String subject, Float impactFactor, Short cycle, Short papers, Double price) {
        this.ISSN = ISSN;
        this.index = index;
        this.subject = subject;
        this.impactFactor = impactFactor;
        this.cycle = cycle;
        this.papers = papers;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getISSN() {
        return ISSN;
    }

    public String getIndex() {
        return index;
    }

    public String getSubject() {
        return subject;
    }

    public Float getImpactFactor() {
        return impactFactor;
    }

    public Short getCycle() {
        return cycle;
    }

    public Short getPapers() {
        return papers;
    }

    public Double getPrice() {
        return price;
    }
}
