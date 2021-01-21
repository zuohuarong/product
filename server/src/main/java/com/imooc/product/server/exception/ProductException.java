package com.imooc.product.server.exception;

import com.imooc.product.server.enums.ResultEnum;

/**
 * @ClassName ProductException
 * @Description
 * @Author zuohuarong
 * @Date 2020-07-27 16:33
 * @Version 1.0
 **/
public class ProductException extends RuntimeException {

  private Integer code;


  public ProductException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public ProductException(ResultEnum resultEnum) {
    super(resultEnum.getMessage());
    this.code = resultEnum.getCode();
  }
}
