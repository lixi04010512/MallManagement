package com.JideMall.mapper;

import com.xxx.store.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictMapperTests {
    @Autowired
    DistrictMapper districtMapper;
    @Test
    void findByParent(){
        List<District> byParent = districtMapper.findByParent("110100");
        for (District s:byParent){
            System.out.println(s);
        }
    }
    @Test
    void findNameByCode(){
        System.out.println(districtMapper.findNameByCode("610000"));
    }
}
