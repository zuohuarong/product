package com.imooc.product.service;

import com.imooc.product.entity.ProductInfo;
import java.util.List;

public interface ProductService {

  /**
   * 查询所以在架商品列表
   * @return
   */
  List<ProductInfo> findUpAll();
}
