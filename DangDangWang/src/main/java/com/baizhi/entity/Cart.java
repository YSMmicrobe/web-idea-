package com.baizhi.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
    private Map<Integer,BookItem> buyBooks = new HashMap<>();
    private Map<Integer,BookItem> noBuyBooks = new HashMap<>();
    private double totalprice;
    private double saveprice;

    public Cart() {
    }

    public Cart(Map<Integer, BookItem> buyBooks, Map<Integer, BookItem> noBuyBooks, double totalprice, double saveprice) {
        this.buyBooks = buyBooks;
        this.noBuyBooks = noBuyBooks;
        this.totalprice = totalprice;
        this.saveprice = saveprice;
    }

    public Map<Integer, BookItem> getBuyBooks() {
        return buyBooks;
    }

    public void setBuyBooks(Map<Integer, BookItem> buyBooks) {
        this.buyBooks = buyBooks;
    }

    public Map<Integer, BookItem> getNoBuyBooks() {
        return noBuyBooks;
    }

    public void setNoBuyBooks(Map<Integer, BookItem> noBuyBooks) {
        this.noBuyBooks = noBuyBooks;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public double getSaveprice() {
        return saveprice;
    }

    public void setSaveprice(double saveprice) {
        this.saveprice = saveprice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "buyBooks=" + buyBooks +
                ", noBuyBooks=" + noBuyBooks +
                ", totalprice=" + totalprice +
                ", saveprice=" + saveprice +
                '}';
    }
}
