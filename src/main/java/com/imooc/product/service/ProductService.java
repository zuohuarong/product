package com.imooc.product.service;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.entity.ProductInfo;
import java.util.List;

public interface ProductService {

  /**
   * 查询所以在架商品列表
   * @return
   */
  List<ProductInfo> findUpAll();

  void update(List<ProductInfo> list);

  /**
   * 查询商品列表
   * @param productIdList
   * @return
   */
  List<ProductInfo> findList(List<String> productIdList);

  /**
   * 扣库存
   * @param cartDTOList
   */
  void decreaseStock(List<CartDTO> cartDTOList);
}
