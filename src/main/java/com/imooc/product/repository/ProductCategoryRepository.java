package com.imooc.product.repository;

import com.imooc.product.entity.ProductCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,String> {

  List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
