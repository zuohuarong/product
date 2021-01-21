package com.imooc.product.server.constant;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 李东升
 * @version 1.0.0
 * @ClassName CommonEnum.java
 * @Description 接口统一返回值类
 * @createTime 2018年12月13日 20:25:00
 */
public enum CommonEnum {

  SUCCESS(0, "访问成功"),
  ERROR(1, "访问失败"),
  SYS_ERROR(3, "系统出现异常，请联系后台开发人员!"),
  SYS_PARAMS_ERROR(4, "{0}个参数有误: {1}"),
  PARAM_ERROR(100101, "参数错误"),
  SIGN_ERROR(100102, "签名错误"),
  SIGN_EMPTY(100103, "签名为空"),
  IPWHITE_CHECK_FAIL(100105, "非法访问"),
  DATE_ERROR(100106, "日期格式错误"),
  DATE_CANNOT_OVERMONTH(100107, "日期范围不能大于一个月"),
  SERVICE_CALL_FAIL(100108, "调用{0}服务失败"),
  LOGIN_EMPTY(100109, "账号或密码为空"),
  LOGIN_FAIL(100110, "账号或密码错误"),
  FILE_EMPTY(100111, "文件不能为空"),
  REMOTE_SERVICE_FAIL(100112, "服务异常,请稍后重试"),

  /*
  publish 里错误code
   */
  PUBLISH_APPNAME_EMPTY(200001, "应用名称不能为空"),
  PUBLISH_APPPUBLISH_EMPTY(200002, "没有查询到应用信息"),
  PUBLISH_APPPUBLISH_NOT_REVOKE(200003, "应用处于复核或发布状态，不能撤回"),
  PUBLISH_APPPUBLISH_NOT_OFFLINE(200004, "应用不发布状态，不需要下架"),
  PUBLISH_APPPUBLISH_NOT_PUBLISH(200005, "应用不处于复核通过状态，不能发布"),
  PUBLISH_APPPUBLISH_NOT_SUBMIT(200006, "应用不处于草稿状态或退回状态，不能提交初审"),
  PUBLISH_APPPUBLISH_NOT_DEL(200003, "应用不处于草稿布状态，不能删除"),

  /*
  api 服务里错误code和描述
   */
  API_AUTHENTICATION_FAILED(301001, "身份证认证失败"),
  API_USERADD_FAILED(301002, "用户信息新增失败"),
  API_USERUPDATE_FAILED(301003, "用户信息更新失败"),
  API_FILE_EMPTY(301004, "文件为空"),
  /*
  manager 服务里错误code码和描述
   */
  MANAGER_CE(400001, ""),
  MANAGER_FILE_EMPTY(400002, "文件为空"),
  MANAGER_ADVISOR_ID(400003, "资讯公告ID为必填参数"),
  MANAGER_ADVISOR_STATUS(400004, "资讯公告状态为必填参数"),
  MANAGER_APP_ID(400005, "appId不能为空"),
  MANAGER_EXAMINE_STATUS(400006, "审核状态不能为空"),
  MANAGER_EXAMINE_RESULT(400007, "审核结果不能为空"),
  MANAGER_EXAMINE_RESULT_NO(400008, "审核不通过原因不能为空"),
  MANAGER_LOGIN_ERROR(400009, "账号或密码错误"),
  MANAGER_JSON_ANALYSIS(400010, "json解析错误"),
  MANAGER_MISSINGCERTIFICATE_NOT_MATCH(400011, "身份证号和有效期不匹配"),
  MANAGER_MISSINGCERTIFICATE_EMPTY(400012, "用户无挂失信息，请先提交挂失信息才能核验"),
  MANAGEE_MISSINGCERTIFICATE_OFFLINE(400013, "请线下办理挂失"),
  MANAGEE_TAG(400014, "审核标识不能为空"),
  MANAGEE_AUDITPERSON(400015, "审核人不能为空"),
  /*
  user 服务里错误code码和描述
   */
  USER_CE(500001, "用户名或密码错误"),
  USER_ID(500002, "用户名ID不能为空"),
  USER_DELETE_ERROR(500003, "请先删除与角色关联关系，然后删除用户信息"),
  USER_ROLE_ID(500004, "角色ID不能为空"),
  USER_ROLE_DELETE_ERROR(500005, "请先删除与角色关联关系，然后删除用户信息"),
  USER_ROLE_DELETE_ERRORS(500006, "请先删除与操作资源关联关系，然后删除角色信息"),
  USER_OPERATION_ID(500007, "操作ID不能为空"),
  USER_OPERATION_DELETE_ERROR(500008, "此操作资源已与角色进行关联，暂不支持删除"),
  USER_OPERATION_IDLIST(500009, "操作资源id集合不能为空"),
  USER_ROLE_IDLIST(500010, "操作资源id集合不能为空"),
  USER_NULL(500011, "没有查询到用户信息"),

  /*
  资讯
   */
  ADVISORY_CM(600001, "");


  private final int value;
  private final String text;

  private CommonEnum(int value, String text) {
    this.value = value;
    this.text = text;
  }

  public static CommonEnum getByValue(int value) {
    for (CommonEnum temp : CommonEnum.values()) {
      if (temp.getValue() == value) {
        return temp;
      }
    }
    return null;
  }

  //获取枚举代码值
  public static String getTextUserStatusEnum(int code) {
    String text = "";
    for (CommonEnum e : CommonEnum.values()) {
      if (e.getValue() == code) {
        return e.getText();
      }
    }
    if (StringUtils.isNotBlank(text)) {
      text = "--";
    }
    return text;
  }

  //获取枚举代码
  public static Integer getKeyUserStatusEnum(String value) {
    Integer key = null;
    for (CommonEnum e : CommonEnum.values()) {
      if (e.getText().equals(value)) {
        key = e.getValue();
      }
    }
    return key;
  }

  public int getValue() {
    return value;
  }

  public String getText() {
    return text;
  }
}
