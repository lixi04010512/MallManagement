package com.jidemall.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {
    //根据分类名称查出分类id
    Long findIdByName(String categoryName);
}
