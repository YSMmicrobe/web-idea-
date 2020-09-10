package com.baizhi.action;

import com.baizhi.entity.Book;
import com.baizhi.entity.BookItem;
import com.baizhi.entity.Cart;
import com.baizhi.service.IBookService;
import com.baizhi.service.impl.BookServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CartAction  {
    private IBookService bookService = new BookServiceImpl();
    HttpSession session = ServletActionContext.getRequest().getSession();
    private Integer book_id;
    private Integer status;

    public void addCart() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter writer = response.getWriter();

        try {
            Cart cart = (Cart) session.getAttribute("cart");
            Book book = bookService.selectOne(book_id);
            if (cart == null){
                cart = new Cart();
                //赋值
                cart.getBuyBooks().put(book_id,new BookItem(book,1));
                countPrice(cart);
                session.setAttribute("cart",cart);
            }else{
                Map<Integer, BookItem> buyBooks = cart.getBuyBooks();
    //            Map<Integer, BookItem> noBuyBooks = cart.getNoBuyBooks();
                if (!buyBooks.containsKey(book_id)){
                    buyBooks.put(book_id,new BookItem(book,1));
                }else {
                    BookItem bookItem = buyBooks.get(book_id);
                    bookItem.setBookNum(bookItem.getBookNum()+1);
                    buyBooks.put(book_id,bookItem);
                }
                countPrice(cart);
                session.setAttribute("cart",cart);
                writer.print("1");
            }
        } catch (Exception e){
            writer.print("0");
        }finally {
            writer.close();
        }
    }

    public String  changeSta(){
        Cart cart = (Cart) session.getAttribute("cart");
        Map<Integer, BookItem> buyBooks = cart.getBuyBooks();
        Map<Integer, BookItem> noBuyBooks = cart.getNoBuyBooks();
        if (status == 1){
            BookItem bookItem = buyBooks.get(book_id);
            buyBooks.remove(book_id);
            noBuyBooks.put(book_id,bookItem);
        }else {
            BookItem bookItem = noBuyBooks.get(book_id);
            noBuyBooks.remove(book_id);
            buyBooks.put(book_id,bookItem);
        }
        countPrice(cart);
        return "success";
    }

    public String  changeNum(){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.getBuyBooks().get(book_id).setBookNum(status);
        countPrice(cart);
        return "success";
    }

    private void countPrice(Cart cart){
        double totalprice = 0;
        double saveprice = 0;
        Map<Integer, BookItem> buyBooks = cart.getBuyBooks();
        Set<Integer> ids = buyBooks.keySet();
        for (Integer id : ids) {
            BookItem bookItem = buyBooks.get(id);
            int bookNum = bookItem.getBookNum();
            Double book_price = bookItem.getBook().getBook_price();
            Double dangprice = bookItem.getBook().getDangprice();
            if (dangprice!=null){
                totalprice += dangprice*bookNum;
                saveprice += (book_price-dangprice)*bookNum;
            }
        }
        cart.setTotalprice(totalprice);
        cart.setSaveprice(saveprice);
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public IBookService getBookService() {
        return bookService;
    }

    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
