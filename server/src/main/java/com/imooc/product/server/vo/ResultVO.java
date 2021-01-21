package com.imooc.product.server.vo;

import com.alibaba.fastjson.JSON;
import com.imooc.product.server.constant.CommonEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName ResultVO
 * @Description
 * @Author zuohuarong
 * @Date 2020-06-22 18:22
 * @Version 1.0
 **/
@Data
public class ResultVO<T> {

  private Integer code;

  private String msg;

  private T data;

  /**
   * 构建统一格式返回对象
   */
  public static <T> ResultVO<T> result(Integer code, String msg, T object) {
    ResultVO<T> result = new ResultVO<T>();
    result.setCode(code);
    result.setMsg(msg);
    result.setData(object);
    return result;
  }

  /**
   * 构建统一格式返回对象
   */
  public static <T> ResultVO<T> result(Integer code, String msg) {
    ResultVO<T> result = new ResultVO<T>();
    result.setCode(code);
    result.setMsg(msg);
    return result;
  }

  /**
   * 执行成功
   */
  public static <T> ResultVO<T> success(T object) {
    ResultVO<T> result = new ResultVO<T>();
    result.setCode(CommonEnum.SUCCESS.getValue());
    result.setMsg(CommonEnum.SUCCESS.getText());
    result.setData(object);
    return result;
  }

  /**
   * 执行成功
   */
  public static <T> ResultVO<T> success() {
    ResultVO<T> result = new ResultVO<T>();
    result.setCode(CommonEnum.SUCCESS.getValue());
    result.setMsg(CommonEnum.SUCCESS.getText());
    return result;
  }

  /**
   * 执行成功
   */
  public static <T> ResultVO<T> success(T object, CommonEnum commonEnum) {
    ResultVO<T> result = new ResultVO<T>();
    result.setCode(commonEnum.getValue());
    result.setMsg(commonEnum.getText());
    result.setData(object);
    return result;
  }

  /**
   * 执行成功
   */
  public static <T> ResultVO<T> success(CommonEnum commonEnum) {
    ResultVO<T> result = new ResultVO<T>();
    result.setCode(commonEnum.getValue());
    result.setMsg(commonEnum.getText());
    return result;
  }

  /**
   * 执行失败
   *
   * @param msg 返回信息
   */
  public static <T> ResultVO<T> error(String msg) {
    ResultVO<T> result = new ResultVO<T>();
    result.setCode(CommonEnum.ERROR.getValue());
    result.setMsg(msg);
    return result;
  }

  /**
   * 执行失败
   */
  public static <T> ResultVO<T> error(Integer code, String msg) {
    ResultVO<T> result = new ResultVO<T>();
    result.setCode(code);
    result.setMsg(msg);
    return result;
  }


  /**
   * 处理远程请求服务结果
   */
  @SuppressWarnings("unchecked")
  public static <T> ResultVO<T> remoteReqResultsHandle(String reqResults) {
    ResultVO<T> result = new ResultVO<T>();

    if (!StringUtils.isBlank(reqResults)) {
      try {
        result = JSON.parseObject(reqResults, ResultVO.class);
//        result = JSONObject.parseObject(reqResults,ResultVO.class);
        if (result.getCode() == CommonEnum.SUCCESS.getValue()) {
          return result;
        }
      } catch (Exception e) {
        // log.error("BaseController --> remoteReqResultsHandle,处理远程请求服务结果错误:"+e.getMessage(),e);
      }
    }

    result.setCode(CommonEnum.REMOTE_SERVICE_FAIL.getValue());
    result.setMsg(CommonEnum.REMOTE_SERVICE_FAIL.getText());
    return result;

  }
}
