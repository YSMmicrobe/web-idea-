package com.baizhi.action;

import com.baizhi.entity.*;
import com.baizhi.service.IAddressService;
import com.baizhi.service.IOrderService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.baizhi.service.impl.IOrderServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

public class OrderAction {
    private IAddressService addressService = new AddressServiceImpl();
    private IOrderService orderService = new IOrderServiceImpl();
    private HttpSession session = ServletActionContext.getRequest().getSession();
    private List<Address> addressList;
    private int addrId;
    private Order order;
    private List<Order> orders;
    private String out_trade_no;

    public String selectAddress(){
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        addressList = addressService.selectAllNowByUId(user.getId());
        return "selectAddress";
    }

    public String addOrder(){
        Cart cart = (Cart) session.getAttribute("cart");
        User user= (User) session.getAttribute("user");
        order = new Order();
        order.setGoodPrice(cart.getTotalprice());
        order.setAddrId(addrId);
        order.setUserId(user.getId());
        //
        orderService.insertOrder(order);
        //
        Collection<BookItem> values = cart.getBuyBooks().values();
        for (BookItem bookItem : values) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(bookItem.getBook().getBook_id());
            orderItem.setCount(bookItem.getBookNum());
            orderItem.setAmount(bookItem.getBook().getDangprice()*bookItem.getBookNum());
            orderService.insertItemOfOrder(orderItem);
        }
        session.removeAttribute("cart");
        return "addOrder";
    }

    public String showOrder(){
        User user= (User) session.getAttribute("user");
        if (user != null){
            orders = orderService.selectOrderByUserId(user.getId());
        }
        return "showOrder";
    }


    public String pay(){
        orderService.updateOrderStatus(Integer.parseInt(out_trade_no));
        return "pay";
    }


    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public IAddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(IAddressService addressService) {
        this.addressService = addressService;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public IOrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
