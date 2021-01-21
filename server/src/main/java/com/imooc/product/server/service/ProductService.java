package com.imooc.product.server.service;

import com.imooc.product.server.dto.CartDTO;
import com.imooc.product.server.entity.ProductInfo;
import java.util.List;

public interface ProductService {

  /**
   * 查询所以在架商品列表
   */
  List<ProductInfo> findUpAll();

  void update(List<ProductInfo> list);

  /**
   * 查询商品列表
   */
  List<ProductInfo> findList(List<String> productIdList);

  /**
   * 扣库存
   */
  void decreaseStock(List<CartDTO> cartDTOList);
}
