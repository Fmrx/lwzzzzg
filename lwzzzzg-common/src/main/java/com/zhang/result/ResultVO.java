package com.zhang.result;

import lombok.Data;

@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;

    protected ResultVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回成功结果
     * @return
     */
    public static <T> ResultVO<T> success() {
        return new ResultVO<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 返回成功结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> failed(ErrorCode errorCode) {
        return new ResultVO<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> failed() {
        return failed(ResultEnum.FAILED);
    }

    /**
     * 返回失败结果
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> failed(String message) {
        return new ResultVO<T>(ResultEnum.FAILED.getCode(), message, null);
    }



}
