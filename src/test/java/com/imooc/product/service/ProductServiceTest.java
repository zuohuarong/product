package com.imooc.product.service;

import com.imooc.product.entity.ProductInfo;
import java.util.Arrays;
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

  @Test
  public void findList(){
    List<ProductInfo> list = productService.findList(Arrays.asList("157875196366160022","157875227953464068"));
    System.out.println(list.size()+"--------");
  }

}