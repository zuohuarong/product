package com.imooc.product.server.controller;

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

  static String a = "1";

  public static void main(String[] args) {
    ServerController s1 = new ServerController();
    System.out.println(ServerController.a);
    ServerController.a = "2";

    System.out.println(ServerController.a);
    System.out.println(s1.msg());
    System.out.println(ServerController.a);
    System.out.println(s1.msg1());
    System.out.println(ServerController.a);

  }

  @GetMapping("/msg")
  public String msg() {
    ServerController.a = "12";
    return "this is msg";
  }

  @GetMapping("/msg1")
  public String msg1() {
    ServerController.a = "13";
    return "this is msg";
  }
}
