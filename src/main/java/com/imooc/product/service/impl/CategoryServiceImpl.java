package com.imooc.product.service.impl;

import com.imooc.product.entity.ProductCategory;
import com.imooc.product.repository.ProductCategoryRepository;
import com.imooc.product.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CategoryServiceImpl
 * @Description
 * @Author zuohuarong
 * @Date 2020-06-22 18:07
 * @Version 1.0
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private ProductCategoryRepository productCategoryRepository;
  @Override
  public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
    return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
  }
}
