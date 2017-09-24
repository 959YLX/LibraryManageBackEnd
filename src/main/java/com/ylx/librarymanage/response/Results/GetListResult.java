package com.ylx.librarymanage.response.Results;

import java.util.List;

public class GetListResult {

    private Integer total;

    private Integer current;

    private List<TableVO> table;

    private List<Object> addition;

    public GetListResult() {
    }

    public GetListResult(Integer total, Integer current, List<TableVO> table, List<Object> addition) {
        this.total = total;
        this.current = current;
        this.table = table;
        this.addition = addition;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public List<TableVO> getTable() {
        return table;
    }

    public void setTable(List<TableVO> table) {
        this.table = table;
    }

    public List<Object> getAddition() {
        return addition;
    }

    public void setAddition(List<Object> addition) {
        this.addition = addition;
    }
}
