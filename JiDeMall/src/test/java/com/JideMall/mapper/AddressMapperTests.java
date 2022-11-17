package com.JideMall.mapper;

import com.xxx.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class AddressMapperTests {
    @Autowired
    AddressMapper addressMapper;
    @Test
    void insert(){
        Address address=new Address();
        address.setAid(1);
        address.setUid(14);
        address.setPhone("123456789");
        address.setName("女朋友");
        addressMapper.insert(address);
    }
    @Test
    void countByUid(){
        System.out.println(addressMapper.countByUid(14));
    }
    @Test
    void findByUid(){
        List<Address> byUid = addressMapper.findByUid(14);
        for (Address a:byUid
             ) {
            System.out.println(a);
        }
    }
    @Test
    void findByAid(){
        Address byAid = addressMapper.findByAid(1);
        System.out.println(byAid);
    }
    @Test
    void updateNonDefault(){
        addressMapper.updateNonDefault(14);
    }
    @Test
    void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(1,"tom",new Date());
    }
    @Test
    void deleteByAid(){
        addressMapper.deleteByAid(2);
    }
}
