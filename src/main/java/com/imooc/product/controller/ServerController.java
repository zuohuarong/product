package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ServerController
 * @Description
 * @Author zuohuarong
 * @Date 2020-07-13 17:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("/")
public class ServerController {

  @GetMapping("/msg")
  public String msg(){
    return "this is msg";
  }

}
