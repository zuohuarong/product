package com.imooc.product.repository;

import com.imooc.product.entity.ProductInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

  List<ProductInfo> findByProductStatus(Integer productStatus);
}
