package com.baizhi;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.IAddressService;
import com.baizhi.service.IUserService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.baizhi.service.impl.UserServiceImpl;
import org.junit.Test;

public class TestAddress {
    private IAddressService addressService = new AddressServiceImpl();

    @Test
    public void testSelectByEmail(){
        addressService.selectAllNowByUId(1).forEach(System.out::println);
    }
    @Test
    public void testInsertOne(){
        Address address = new Address(1,1,"张三","北京朝阳","12312312222",1,1,null);
        addressService.insertOne(address);
    }

    @Test
    public void testUpdateStatus(){
        addressService.updateState("delete_state = 0",1);
        addressService.updateState("selected_state = 0",1);
    }

}
