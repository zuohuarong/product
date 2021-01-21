package com.imooc.product.server.repository;

import com.imooc.product.server.entity.ProductInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

  List<ProductInfo> findByProductStatus(Integer productStatus);

  List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
