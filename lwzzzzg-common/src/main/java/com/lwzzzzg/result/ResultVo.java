package com.lwzzzzg.result;


import lombok.Data;

@Data
public class ResultVo<T> {

    private Integer code;

    private String message;

    private T data;

    protected ResultVo(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回成功结果
     * @return
     */
    public static <T> ResultVo<T> success() {
        return new ResultVo<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 返回成功结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultVo<T> success(T data) {
        return new ResultVo<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> ResultVo<T> failed(ErrorCode errorCode) {
        return new ResultVo<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 返回失败结果
     * @param <T>
     * @return
     */
    public static <T> ResultVo<T> failed() {
        return failed(ResultEnum.FAILED);
    }

    /**
     * 返回失败结果
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResultVo<T> failed(String message) {
        return new ResultVo<T>(ResultEnum.FAILED.getCode(), message, null);
    }



}
