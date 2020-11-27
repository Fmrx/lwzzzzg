package com.lwzzzzg.handler;

import com.lwzzzzg.result.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @Author fmrx
 * @Date 2020/11/21
 */
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResultVo handleValidException(Exception e) {
        if(e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            return ResultVo.failed(methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        } else if(e instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            return ResultVo.failed(getExceptionMessage(constraintViolationException));
        }
        return ResultVo.failed();
    }

    private String getExceptionMessage(ConstraintViolationException e) {
        return e.getMessage().split(":")[1].trim();
    }
}
