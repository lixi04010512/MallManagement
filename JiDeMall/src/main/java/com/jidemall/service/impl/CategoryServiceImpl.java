package com.jidemall.service.impl;

import com.jidemall.entity.Category;
import com.jidemall.mapper.CategoryMapper;
import com.jidemall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Long findIdByName(String categoryName) {
        return null;
    }

    @Override
    public String findName(Long productId) {
        String categoryName = categoryMapper.findName(productId);
        return categoryName;
    }
}
