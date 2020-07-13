package com.imooc.product.service;

import com.imooc.product.entity.ProductInfo;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

  @Autowired
  private ProductService productService;

  @Test
  public void findUpAll(){
    List<ProductInfo> list = productService.findUpAll();
    System.out.println(list.size() + "-------");
  }
}