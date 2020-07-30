package com.imooc.product.service.impl;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.entity.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
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

  public static void main(String[] args) {

    Double a = 21744.0568;
    Double b = 10000.0;
    Double c = a * b;
    System.out.println(c);

    BigDecimal aa = new BigDecimal(21744.0568);
    BigDecimal bb = new BigDecimal(10000);
    BigDecimal cc = aa.multiply(bb);
    System.out.println(cc.setScale(4, RoundingMode.HALF_DOWN));
    System.out.println(new BigDecimal(2.1744056799999997E8));
  }

  @Override
  public List<ProductInfo> findUpAll() {
    return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
  }

  @Override
  public void update(List<ProductInfo> list) {

  }

  @Override
  public List<ProductInfo> findList(List<String> productIdList) {
    return productInfoRepository.findByProductIdIn(productIdList);
  }

  @Override
  @Transactional
  public void decreaseStock(List<CartDTO> cartDTOList) {

    for (CartDTO cartDTO : cartDTOList) {
      Optional<ProductInfo> productInfoOptional = productInfoRepository
          .findById(cartDTO.getProductId());
      //商品是否存在
      if (!productInfoOptional.isPresent()) {
        throw new ProductException(ResultEnum.PRODUCT_NOT_EXIT);
      }

      ProductInfo productInfo = productInfoOptional.get();
      Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
      //库存是否充足
      if (result < 0) {
        throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
      }

      productInfo.setProductStock(result);
      productInfoRepository.save(productInfo);

    }
  }
}
