package com.jidemall.mapper;

import com.jidemall.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {
    //根据分类名称查出分类id
    Long findIdByName(String categoryName);

    //联表查询商品对应的分类名称
    String findName(Long productId);
}
