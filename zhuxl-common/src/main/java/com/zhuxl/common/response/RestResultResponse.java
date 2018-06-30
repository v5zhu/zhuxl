package com.zhuxl.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestResultResponse<T> {
    /**
     * 服务器响应数据
     */
    private T payload;

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 状态码
     */
    private Integer code = -1;

    private RestResultResponse() {
    }

    public RestResultResponse(boolean success, T payload) {
        this.success = success;
        this.payload = payload;
    }

    public RestResultResponse(boolean success, T payload, int code) {
        this.success = success;
        this.payload = payload;
        this.code = code;
    }

    public RestResultResponse(boolean success, String msg) {
        this.success = success;
        this.error = msg;
    }

    public RestResultResponse(boolean success, String msg, int code) {
        this.success = success;
        this.error = msg;
        this.code = code;
    }

    public static RestResultResponse ok() {
        return new RestResultResponse(true, null);
    }

    public static <T> RestResultResponse ok(T payload) {
        return new RestResultResponse(true, payload);
    }

    public static <T> RestResultResponse ok(T payload, int code) {
        return new RestResultResponse(true, payload, code);
    }

    public static RestResultResponse fail() {
        return new RestResultResponse(false, "请求失败");
    }

    public static RestResultResponse fail(String msg) {
        return new RestResultResponse(false, msg);
    }

    public static RestResultResponse fail(int code) {
        return new RestResultResponse(false, null, code);
    }

    public static RestResultResponse fail(int code, String msg) {
        return new RestResultResponse(false, msg, code);
    }
}
