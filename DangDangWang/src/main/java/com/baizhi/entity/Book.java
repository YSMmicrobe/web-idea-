package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * book_id  number(6) primary key not null,--图书Id
 *    cid  number(12) references d_category(category_id),--图书的类别编号
 *    book_name varchar2(50) not null,--图书name
 *    book_price number(12,2) not null,--图书价格
 *    groundingDate date,--上架时间
 *    inventory  number(6) not null,--库存
 *    author  varchar2(35),--作者
 *    salenum  number(10)  not null,--销量
 *    messages   varchar2(360),--内容简介
 *    Dangprice  number(12, 2) not null,--当当价
 *    product_image varchar2(100)--商品图片
 */
public class Book implements Serializable {
    private Integer book_id;
    private Integer cid;
    private String book_name;
    private Double book_price;
    private Date groundingDate;
    private Long inventory;
    private String author;
    private Integer salenum;
    private String messages;
    private Double dangprice;
    private String product_image;
    private String category_name;
    private String parent_category_name;
    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Double getBook_price() {
        return book_price;
    }

    public void setBook_price(Double book_price) {
        this.book_price = book_price;
    }

    public Date getGroundingDate() {
        return groundingDate;
    }

    public void setGroundingDate(Date groundingDate) {
        this.groundingDate = groundingDate;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSalenum() {
        return salenum;
    }

    public void setSalenum(Integer salenum) {
        this.salenum = salenum;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Double getDangprice() {
        return dangprice;
    }

    public void setDangprice(Double dangprice) {
        this.dangprice = dangprice;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getParent_category_name() {
        return parent_category_name;
    }

    public void setParent_category_name(String parent_category_name) {
        this.parent_category_name = parent_category_name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", cid=" + cid +
                ", book_name='" + book_name + '\'' +
                ", book_price=" + book_price +
                ", groundingDate=" + groundingDate +
                ", inventory=" + inventory +
                ", author='" + author + '\'' +
                ", salenum=" + salenum +
                ", messages='" + messages + '\'' +
                ", dangprice=" + dangprice +
                ", product_image='" + product_image + '\'' +
                ", category_name='" + category_name + '\'' +
                ", parent_category_name='" + parent_category_name + '\'' +
                '}';
    }
}
