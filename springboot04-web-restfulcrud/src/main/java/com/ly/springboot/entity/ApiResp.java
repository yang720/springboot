package com.ly.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ly.springboot.utils.JsonUtils;
import com.ly.springboot.utils.error.code.IEnumError;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 所有服务统一响应数据格式
 *
 * @author liuyang
 * @date 2020/2/29 17:45
 */
@ApiModel(description = "接口统一响应体")
@Data
public class ApiResp<T> implements Serializable {

    private static final long serialVersionUID = 9211889136173018364L;

    /**
     * 正常响应码
     */
    private static final int SUCCESS_CODE = 200;

    /**
     * 正常响应消息
     */
    private static final String SUCCESS_MSG = "SUCCESS";

    /**
     * 错误码
     */
    @ApiModelProperty(value = "错误码")
    private int code = SUCCESS_CODE;

    /**
     * 错误信息
     */
    @ApiModelProperty(value = "错误信息")
    private String msg = SUCCESS_MSG;

    /**
     * 响应内容，默认为null
     */
    @ApiModelProperty(value = "响应内容")
    private T data = null;

    /**
     * 是否的正常响应
     *
     * @return true=正常；false=异常
     */
    @JsonIgnore
    public boolean isOK() {
        return code == SUCCESS_CODE;
    }

    /**
     * 无data的正常返回
     */
    public static ApiResp retOK() {
        return new ApiResp();
    }

    /**
     * 有data的正常返回
     *
     * @param data data内容
     * @param <T> data类型
     */
    public static <T> ApiResp<T> retOK(T data) {
        ApiResp<T> response = new ApiResp<>();
        response.setData(data);
        return response;
    }

    /**
     * 无data的失败返回
     *
     * @param error 错误类型
     */
    public static ApiResp retFail(IEnumError error) {
        return retFail(error.getCode(), error.getMsg());
    }

    /**
     * 有data的失败返回
     *
     * @param error 错误类型
     * @param data 详细错误信息
     */
    public static <T> ApiResp<T> retFail(IEnumError error, T data) {
        return retFail(error.getCode(), error.getMsg(), data);
    }

    /**
     * 无data的失败返回
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> ApiResp<T> retFail(int code, String msg) {
        ApiResp<T> response = new ApiResp<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    /**
     * 有data的失败返回
     * <br>
     * 失败返回的场景不多，所以没有严格要求T泛型
     *
     * @param code 错误码
     * @param msg 错误信息
     */
    public static <T> ApiResp<T> retFail(int code, String msg, T data) {
        ApiResp<T> response = new ApiResp<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    @Override
    public String toString() {
        return JsonUtils.obj2Json(this);
    }
}
