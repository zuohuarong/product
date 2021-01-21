package com.imooc.product.server.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @ClassName ProductInfo
 * @Description
 * @Author zuohuarong
 * @Date 2020-06-19 16:35
 * @Version 1.0
 **/
@Data
//@Table(name = "product_info")
@Entity
public class ProductInfo {

  @Id
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
