package com.imooc.product.service.impl;

import com.imooc.product.entity.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName ProductServiceImpl
 * @Description
 * @Author zuohuarong
 * @Date 2020-06-22 17:24
 * @Version 1.0
 **/
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductInfoRepository productInfoRepository;

  @Override
  public List<ProductInfo> findUpAll() {
    return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
  }
}
