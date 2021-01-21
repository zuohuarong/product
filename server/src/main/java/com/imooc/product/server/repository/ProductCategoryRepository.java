package com.imooc.product.server.repository;

import com.imooc.product.server.entity.ProductCategory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

  List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
