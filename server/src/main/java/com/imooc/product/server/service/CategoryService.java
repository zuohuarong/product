package com.imooc.product.server.service;

import com.imooc.product.server.entity.ProductCategory;
import java.util.List;

public interface CategoryService {

  List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
