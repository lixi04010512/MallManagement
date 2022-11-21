package com.jidemall.service;

public interface CategoryService {
    //根据分类名称查出分类id
    Long findIdByName(String categoryName);
}
