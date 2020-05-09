package com.webproject.icollect.controller;

import com.webproject.icollect.pojo.TestDO;
import com.webproject.icollect.pojo.TestVO;
import com.webproject.icollect.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
public class Testontroller {
    @Autowired
    private TestService testService;

    @GetMapping("/")
    @ApiOperation(value="获取Test列表", notes="")
    public TestVO hello(){
        return new TestVO(testService.selectAll(),1);
    }
}
