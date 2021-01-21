package com.imooc.product.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @ClassName ProductInfoVO
 * @Description
 * @Author zuohuarong
 * @Date 2020-06-22 18:25
 * @Version 1.0
 **/
@Data
public class ProductInfoVO {

  @JsonProperty("id")
  private String productId;

  @JsonProperty("name")
  private String productName;

  @JsonProperty("price")
  private BigDecimal productPrice;

  @JsonProperty("description")
  private String productDescription;

  @JsonProperty("icon")
  private String productIcon;

}
