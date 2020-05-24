package com.webproject.icollect.utils;

import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.utils.exception.GlobalExceptionBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     * @param exception
     * @return
     */

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        ResultVO<String> resultVO = null;
        HttpStatus status = HttpStatus.OK;
        if(exception instanceof GlobalExceptionBase){
            // 自定义全局异常
            GlobalExceptionBase globalExceptionBase = (GlobalExceptionBase)exception;
            resultVO = new ResultVO<String>(globalExceptionBase.getCode(),globalExceptionBase.getMessage(),exception.toString());
            status = HttpStatus.resolve(globalExceptionBase.getCode());
        }else if(exception instanceof MissingServletRequestParameterException){
            // 请求参数错误异常
            resultVO = new ResultVO<String>(400,"参数错误",exception.toString());
            status = HttpStatus.BAD_REQUEST;
        }
        else {
            // 其他异常
            exception.printStackTrace();
            resultVO = new ResultVO<String>(500,"服务器错误",exception.toString());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultVO,status);
    }
}
