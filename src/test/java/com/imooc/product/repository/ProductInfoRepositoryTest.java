package com.imooc.product.repository;


import com.imooc.product.entity.ProductInfo;
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
}