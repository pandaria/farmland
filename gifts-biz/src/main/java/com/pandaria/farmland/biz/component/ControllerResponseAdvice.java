package com.pandaria.farmland.biz.component;

import com.pandaria.farmland.biz.component.exception.RecordAlreadyExistsException;
import com.pandaria.farmland.biz.component.exception.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ControllerResponseAdvice {

    @ExceptionHandler({RecordAlreadyExistsException.class, RecordNotFoundException.class})
    @ResponseBody
    public ResponseEntity wrapperResponse(Exception e, HttpServletResponse response) {
        return null;
    }
}
