package com.imooc.product.repository;


import com.imooc.product.entity.ProductInfo;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import org.junit.jupiter.api.Assertions;

//@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoRepositoryTest {

  @Autowired
  private ProductInfoRepository productInfoRepository;

  @Test
  public void findByProductStatus() throws Exception{

    List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
//    Assert
    System.out.println(list.size()+"-----");
  }

  @Test
  public void findByProductIdIn(){
    List<ProductInfo> list = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
    System.out.println(list.size()+"-------------");
  }
}