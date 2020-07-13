package com.imooc.product.service;

import static org.junit.jupiter.api.Assertions.*;

import com.imooc.product.entity.ProductCategory;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {

  @Autowired
  private CategoryService categoryService;

  @Test
  public void findByCategoryTypeIn(){
    List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11,12));
    System.out.println(((List) list).size() + "----");
  }
}