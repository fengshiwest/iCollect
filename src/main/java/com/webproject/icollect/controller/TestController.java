package com.webproject.icollect.controller;

import com.webproject.icollect.pojo.vo.TestVO;
import com.webproject.icollect.service.TestService;
import com.webproject.icollect.utils.exception.GlobalExceptionBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/")
    @ApiOperation(value="获取Test列表", notes="")
    public TestVO hello(){
//        throw new GlobalExceptionBase(300,"hhhh");
        return new TestVO(testService.selectAll(),1);
    }
}
