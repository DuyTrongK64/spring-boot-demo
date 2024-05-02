package com.GR3.demo.exception;

import com.GR3.demo.dto.ApiRespose;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
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
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiRespose> handlingValidation(MethodArgumentNotValidException exception){
        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        }
        catch (IllegalArgumentException e){

        }

        ApiRespose apiRespose = new ApiRespose();
        apiRespose.setCode(errorCode.getCode());
        apiRespose.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiRespose);

    }
}
