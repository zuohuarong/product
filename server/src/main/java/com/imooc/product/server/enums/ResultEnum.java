package com.imooc.product.server.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
  PRODUCT_NOT_EXIT(1, "商品不存在"),
  PRODUCT_STOCK_ERROR(1, "库存不足"),
  ;

  private Integer code;

  private String message;

  ResultEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
