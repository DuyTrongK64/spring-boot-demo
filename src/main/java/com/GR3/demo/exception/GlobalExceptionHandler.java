package com.GR3.demo.exception;

import com.GR3.demo.dto.request.ApiRespose;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiRespose> handlingRuntimeException(RuntimeException exception){
        ApiRespose apiRespose = new ApiRespose();
        apiRespose.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiRespose.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiRespose);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiRespose> handlingAppException(AppException exception){
        ErrorCode errorCode = exception.getErrorCode();
        ApiRespose apiRespose = new ApiRespose();
        apiRespose.setCode(errorCode.getCode());
        apiRespose.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(apiRespose);
    }
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    ResponseEntity<String> handlingValidation(MethodArgumentNotValidException exception){
//        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
//
//    }
}
