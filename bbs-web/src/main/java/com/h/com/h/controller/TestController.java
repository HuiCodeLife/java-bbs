package com.h.com.h.controller;

import com.h.core.BaseController;
import com.h.entity.vo.ResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Lin
 * @since: 2023-05-03
 */
@RestController
public class TestController extends BaseController {
    @GetMapping("/test")
    public ResponseVo test(Integer id){
        ResponseVo<String> responseVo = new ResponseVo<>();
        responseVo.setData("123");
        int a=  1/id;
        return getSuccessResponseVo(responseVo);
    }
}
