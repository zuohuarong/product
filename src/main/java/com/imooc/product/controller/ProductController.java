package com.imooc.product.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.entity.ProductCategory;
import com.imooc.product.entity.ProductInfo;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.vo.ProductInfoVO;
import com.imooc.product.vo.ProductVO;
import com.imooc.product.vo.ResultVO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductController
 * @Description
 * @Author zuohuarong
 * @Date 2020-06-19 16:32
 * @Version 1.0
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @Autowired
  private CategoryService categoryService;

  public static void main(String[] args) {
    List names = new ArrayList();

    names.add("Google");
    names.add("Runoob");
    names.add("Taobao");
    names.add("Baidu");
    names.add("Sina");

//    names.forEach(System.out::println);
//    names.forEach(name ->
//      System.out.println(name)
//    );

//    Random random = new Random();
//    random.ints().limit(10).forEach(System.out::println);

    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    List<String> filtered = strings.stream().filter(string -> !string.isEmpty())
        .collect(Collectors.toList());

//    System.out.println("筛选列表: " + filtered);
//    String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
//    System.out.println("合并字符串: " + mergedString);

    // 获取当前时间日期
//    ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
//    System.out.println("date1: " + date1);
//    ZoneId id = ZoneId.of("Europe/Paris");
//    System.out.println("ZoneId: " + id);
//    ZoneId currentZone = ZoneId.systemDefault();
//    System.out.println("当期时区: " + currentZone);

    // 获取当前的日期时间
    LocalDateTime currentTime = LocalDateTime.now();
    System.out.println("当前时间: " + currentTime);

    LocalDate date1 = currentTime.toLocalDate();
    System.out.println("date1: " + date1);

    Month month = currentTime.getMonth();
    int day = currentTime.getDayOfMonth();
    int seconds = currentTime.getSecond();

    System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);

    LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
    System.out.println("date2: " + date2);

    // 12 december 2014
    LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
    System.out.println("date3: " + date3);

    // 22 小时 15 分钟
    LocalTime date4 = LocalTime.of(22, 15);
    System.out.println("date4: " + date4);

    // 解析字符串
    LocalTime date5 = LocalTime.parse("20:15:30");
    System.out.println("date5: " + date5);

  }

  /**
   * 1.查询所以商品 2。获取类目type列表 3。查询类目 4。构造数据
   *
   * @return 注意：,produces = {"application/json;charset=UTF-8"}  ,produces =
   * {"application/xml;charset=UTF-8"}
   */
  @GetMapping(value = "/list", produces = {"application/xml;charset=UTF-8"})
  public ResultVO<List<ProductVO>> list() {
    // 1.查询所以商品
    List<ProductInfo> productInfoList = productService.findUpAll();
    //2。获取类目type列表
    List<Integer> categoryTypeList = productInfoList.stream()
        .map(ProductInfo::getCategoryType).collect(
            Collectors.toList());
    //3。查询类目
    List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
    //4。构造数据
    List<ProductVO> productVOS = new ArrayList<>();
    categoryList.forEach(category -> {
      ProductVO productVO = new ProductVO();
      productVO.setCategoryName(category.getCategoryName());
      productVO.setCategoryType(category.getCategoryType());

      List<ProductInfoVO> productInfos = new ArrayList<>();
      productInfoList.forEach(productInfo -> {
        if (productInfo.getCategoryType() == category.getCategoryType()) {
          ProductInfoVO productInfoVO = new ProductInfoVO();
          BeanUtils.copyProperties(productInfo, productInfoVO);
          productInfos.add(productInfoVO);
        }
      });
      productVO.setProductInfoVOS(productInfos);
      productVOS.add(productVO);
    });

    System.out.println("----------");
    System.out.println(JSON.toJSON(productVOS));
    return ResultVO.success(productVOS);
  }

  @GetMapping("/findList")
  public List<ProductInfo> findList(@RequestParam(value = "productIdList") List<String> productIdList){

    return productService.findList(productIdList);
  }


  @PostMapping("/findList1")
  public List<ProductInfo> findList1(@RequestBody List<String> productIdList){

    return productService.findList(productIdList);
  }

  /**
   * 减商品库存
   * @param cartDTOList
   */
  @PostMapping("decrease")
  public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
    productService.decreaseStock(cartDTOList);
  }

}
