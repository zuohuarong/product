package com.imooc.product.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.imooc.product.entity.ProductCategory;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductCategoryRepositoryTest {

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @Test
  public void findByCategoryTypeIn(){
    List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,12));
    System.out.println(list.size()+"-----");
  }
}