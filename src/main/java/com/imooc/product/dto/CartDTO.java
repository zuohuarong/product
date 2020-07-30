package com.imooc.product.dto;

import lombok.Data;

/**
 * @ClassName CartDTO
 * @Description
 * @Author zuohuarong
 * @Date 2020-07-24 16:22
 * @Version 1.0
 **/
@Data
public class CartDTO {

  private String productId;

  private Integer productQuantity;
}
