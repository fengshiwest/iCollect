package com.webproject.icollect.controller;


import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.UserDO;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.DonateService;
import com.webproject.icollect.utils.TokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.DonateService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Wan Yu on 2020/5/18
 */


@RestController
@Api("捐赠")
public class DonateController {

    @Autowired
    private DonateService donateService;

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/getDonationByProject")
    public ResultVO<Object> getDonationByProject(@RequestParam("pid") String pid) {
        List<DonateDO> donateList = donateService.getDonationByProject(pid);
        return new ResultVO<>(200,"success",donateList);
    }
    //donor相当于用户的uid，需要从token中获取
    @GetMapping("/getDonationByDonor")
    public ResultVO<Object> getDonationByDonor(@RequestHeader String token) {
        if(token != null){
            int donor;
            try{
                donor = Integer.valueOf(TokenUtil.verifyToken(token).get("id"));
                List<DonateDO> donateList = donateService.getDonationByDonor(donor);
                return new ResultVO<>(200,"success",donateList);
            }catch (SignatureVerificationException | JWTDecodeException e){
                return new ResultVO<>(400,"未登录",null);
            }
        }
        else{
            return new ResultVO<>(400,"未登录",null);
        }
    }

    @GetMapping("/getDonationByDonee")
    public ResultVO<Object> getDonationByDonee(@RequestParam("donee") int donee) {
        List<DonateDO> donateList = donateService.getDonationByDonee(donee);
        return new ResultVO<>(200,"success",donateList);
    }


    //如果不用get方式访问addDonation可把这个方法和对应的donationService等内容删除
    public ResponseEntity<Object> getUserToken(@RequestHeader("token") String token){
//        String token = request.getHeader("token");
        if(token != null){
            int id;
            try {
                id = Integer.valueOf(TokenUtil.verifyToken(token).get("id"));
            }catch (SignatureVerificationException | JWTDecodeException e){
                return new ResponseEntity<>(new ResultVO<Object>(400,"未登录",null), HttpStatus.UNAUTHORIZED);
            }
            UserDO user = donateService.getUserToken(id);
            return new ResponseEntity<Object>(new ResultVO<UserDO>(200,"success",user),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new ResultVO<Object>(400,"未登录",null),HttpStatus.UNAUTHORIZED);
        }

    }


    @PostMapping("addDonation")
    public ResultVO<Object> addDonation(@RequestBody DonateDO donateDO,
                                        @RequestHeader("token") String token){
//原不带token的方法
//        try{
//            //donateDo的money是Double类型，和原本的moneyValue不同，修改时需要注意
//            //double money = Double.parseDouble(moneyValue);
//            //DonateDO donateDO = new DonateDO(pid,donor,donee,money);
//
//            String did = getUUID();
//            donateDO.setDid(did);
//            String dtime = getTime();
//            donateDO.setDtime(dtime);
//
//            donateService.addDonation(donateDO);
//            return new ResultVO<>(200, "success", donateDO);
//        }
//        catch(NumberFormatException e){
//            return new ResultVO<>(403,"金额有误",null);
//        }

        if(token != null){
            try{

                String did = getUUID();
                donateDO.setDid(did);
                int donor = Integer.valueOf(TokenUtil.verifyToken(token).get("id"));
                donateDO.setDonor(donor);
                String dtime = getTime();
                donateDO.setDtime(dtime);
                donateService.addDonation(donateDO);
                return new ResultVO<>(200, "success", donateDO);
            }
            catch (SignatureVerificationException | JWTDecodeException e){
                return new ResultVO<Object>(400,"未登录",null);
            }
        }
        else{
            return new ResultVO<Object>(400,"未登录",null);
        }

    }

    //获取时间
    private String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    private String getUUID(){
        String uuid =  UUID.randomUUID().toString();
        return uuid;
    }



}
