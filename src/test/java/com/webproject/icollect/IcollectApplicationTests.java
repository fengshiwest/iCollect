package com.webproject.icollect;



import com.webproject.icollect.pojo.CommentDO;
import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.UserDO;
import com.webproject.icollect.pojo.vo.ResultVO;

import com.webproject.icollect.pojo.CommentDO;
import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.UserDO;

import com.webproject.icollect.service.CommentService;
import com.webproject.icollect.service.DonateService;
import com.webproject.icollect.service.LoginService;
import com.webproject.icollect.utils.TokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class IcollectApplicationTests {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private DonateService donateService;

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

        UserDO user = new UserDO("user4","12345");
        UserDO userDO = loginService.userRegister(user);
        System.out.println(userDO);
        userDO = loginService.getUserInfo(10);
        System.out.println(userDO);

//        UserDO user = new UserDO("user4","12345");
//        UserDO userDO = loginService.userRegister(user);
//        System.out.println(userDO);
//        userDO = loginService.getUserInfo(10);
//        System.out.println(userDO);

    }


    @Test
    void testComment(){
//        CommentDO comment = new CommentDO("2","1","666");
//        comment.setCid("123");
//        comment.setCtime("123");
//        commentService.addComment(comment);

        UserDO user = new UserDO(1,"user","123456",1,"de.jpg");
        String token = TokenUtil.getToken(user);
        System.out.println(token);
        String uid = TokenUtil.verifyToken(token).get("id");
        List<CommentDO> commentDO = commentService.getCommentByTime("1");
        CommentDO cd = new CommentDO("1",uid,"hello world");
        String cid = "22";
        cd.setCid(cid);
        String ctime = "2";
        cd.setCtime(ctime);
        commentService.addComment(cd);
        //System.out.println(commentDO);




//        List<CommentDO> commentDO = commentService.getCommentByTime("2");
//        System.out.println(commentDO);

    }

    @Test
    void testDonate(){
//        DonateDO donate = new DonateDO("1","小明","小红",0.01);
//        donate.setDtime("2020-05-17 23:11:56");
//        donate.setDid("20200517231156");
//        donateService.addDonation(donate);


        List<DonateDO> donateDOList1 = donateService.getDonationByProject("1");
        System.out.println(donateDOList1.get(0).getDid());

        List<DonateDO> donateDOList2 = donateService.getDonationByDonor("小明");
        System.out.println(donateDOList2.get(0).getDid());

        List<DonateDO> donateDOList3 = donateService.getDonationByDonee("小红");
        System.out.println(donateDOList3.get(0).getDid());
        UserDO user = new UserDO(1,"user","123456",1,"de.jpg");
        String token = TokenUtil.getToken(user);
        System.out.println(token);
        String uid = TokenUtil.verifyToken(token).get("id");
        DonateDO donateDO = new DonateDO("1",uid,"2",0.01);
        donateDO.setDid("1111");
        donateDO.setDtime("2020-05-17 23:11:56");
        donateService.addDonation(donateDO);

//        List<DonateDO> donateDOList1 = donateService.getDonationByProject("1");
//        System.out.println(donateDOList1.get(0).getDid());
//
//        List<DonateDO> donateDOList2 = donateService.getDonationByDonor("小明");
//        System.out.println(donateDOList2.get(0).getDid());
//
//        List<DonateDO> donateDOList3 = donateService.getDonationByDonee("小红");
//        System.out.println(donateDOList3.get(0).getDid());


    }

}
