package com.imooc.product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @ClassName ProductCategory
 * @Description
 * @Author zuohuarong
 * @Date 2020-06-19 17:41
 * @Version 1.0
 **/
@Data
@Entity
public class ProductCategory {

  @Id
  private String categoryId;

  /**
   * 类目名字
   */
  private String categoryName;

  /**
   * 类目编号
   */
  private Integer categoryType;

}
