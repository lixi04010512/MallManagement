package com.JideMall.service;

import com.xxx.store.entity.Address;
import com.xxx.store.mapper.AddressMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressServiceTests {
    @Autowired
    AddressService addressService;

    @Test
    void addNewAddress(){
        Address address=new Address();
        address.setAid(1);
        address.setUid(14);
        address.setPhone("12345678");
        address.setName("朋友");
        addressService.addNewAddress(14,"456",address);
    }
    @Test
    void setDefault(){
        addressService.setDefault(2,14,"tom");
    }
    @Test
    void delete(){
        addressService.delete(1,14,"tom");

    }
}
