package com.imooc.product.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 * @ClassName ProductVO
 * @Description
 * @Author zuohuarong
 * @Date 2020-06-22 18:24
 * @Version 1.0
 **/
@Data
public class ProductVO {

  @JsonProperty("name")
  private String categoryName;

  @JsonProperty("type")
  private Integer categoryType;

  @JsonProperty("foods")
  private List<ProductInfoVO> productInfoVOS;
}
