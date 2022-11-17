package com.JideMall.service;

import com.xxx.store.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictServiceTests {
    @Autowired
    DistrictService districtService;
    @Test
    void getByParent(){
        List<District> byParent = districtService.getByParent("86");
        for (District d:byParent
             ) {
            System.out.println(d);
        }
    }
}
