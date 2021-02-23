package com.omri.demo.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Catalog {
    private Long item_no;
    private String name;
    private int amount;
    private int inv_code;


    public Catalog(String name, int amount, int inv_code) {

        this.name = name;
        this.amount = amount;
        this.inv_code = inv_code;
    }

    public Long getItem_no() {
        return item_no;
    }

    public void setItem_no(Long item_no) {
        this.item_no = item_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return amount == catalog.amount &&
                Objects.equals(item_no, catalog.item_no) &&
                Objects.equals(inv_code, catalog.inv_code) &&
                Objects.equals(name, catalog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_no, name, amount, inv_code);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Catalog.class.getSimpleName() + "[", "]")
                .add("item_no=" + item_no)
                .add("name='" + name + "'")
                .add("amount=" + amount)
                .add("inv_code=" + inv_code)
                .toString();
    }

}
