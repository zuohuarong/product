package com.imooc.product.common;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @ClassName DecreaseStockInput
 * @Description
 * @Author zuohuarong
 * @Date 2021-01-20 10:13
 * @Version 1.0
 **/
@Data
public class DecreaseStockInput {

  private String productId;
  /**
   * 商品名称
   */
  private String productName;
  /**
   * 单价
   */
  private BigDecimal productPrice;
  /**
   * 库存
   */
  private Integer productStock;
  /**
   * 描述
   */
  private String productDescription;
  /**
   * 小图
   */
  private String productIcon;
  /**
   * 商品状态,0正常1下架
   */
  private Integer productStatus;
  /**
   * 类目编号
   */
  private Integer categoryType;
  private Date createTime;
  private Date updateTime;
}
