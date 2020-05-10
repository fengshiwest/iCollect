package com.webproject.icollect;

import com.webproject.icollect.pojo.UserDO;
import com.webproject.icollect.service.LoginService;
import com.webproject.icollect.utils.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class IcollectApplicationTests {

    @Autowired
    private LoginService loginService;

    @Test
    void contextLoads() {
    }

    @Test
    void testToken(){
        UserDO user = new UserDO(1,"user","123456",1,"de.jpg");
        String token = TokenUtil.getToken(user);
        System.out.println(token);
        String s = TokenUtil.verifyToken(token).get("role");
        System.out.println(s);
        System.out.println(TokenUtil.verifyToken(token));
//        System.out.println(new Date());
    }

    @Test
    void testUser(){
        UserDO user = new UserDO("user3","12345");
        UserDO userDO = loginService.userRegister(user);
        System.out.println(userDO);
        userDO = loginService.getUserInfo(10);
        System.out.println(userDO);
    }

}
