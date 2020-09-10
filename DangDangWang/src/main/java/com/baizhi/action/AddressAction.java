package com.baizhi.action;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.IAddressService;
import com.baizhi.service.impl.AddressServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class AddressAction {
    private IAddressService addressService = new AddressServiceImpl();
    private List<Address> addressList;
    private Address address;
    private Integer uid;

    public String adrsList(){
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        if (user != null){
            addressList = addressService.selectAllNowByUId(user.getId());
            return "adrsList";
        }else{
            return "error";
        }
    }
    //默认收货地址
    public String updateSelState(){
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        List<Address> addressList1 = addressService.selectAllNowByUId(user.getId());
        for (Address address1 : addressList1) {
            if (address1.getSeleState()==1){
                addressService.updateState("selected_state = 0",address1.getId());
            }
        }
        addressService.updateState("selected_state = 1",address.getId());
        return "success";
    }
    //"删除"收货地址
    public String updateDelState(){
        addressService.updateState("delete_state = 1",address.getId());
        return "success";
    }

    public String insertAdrs(){
        addressService.insertOne(address);
        return "success";
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
