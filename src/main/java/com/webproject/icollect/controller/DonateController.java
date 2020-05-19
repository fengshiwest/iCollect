package com.webproject.icollect.controller;

import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.DonateService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getDonationByDonor")
    public ResultVO<Object> getDonationByDonor(@RequestParam("donor") String donor) {
        List<DonateDO> donateList = donateService.getDonationByDonor(donor);
        return new ResultVO<>(200,"success",donateList);
    }

    @GetMapping("/getDonationByDonee")
    public ResultVO<Object> getDonationByDonee(@RequestParam("donee") String donee) {
        List<DonateDO> donateList = donateService.getDonationByDonee(donee);
        return new ResultVO<>(200,"success",donateList);
    }

    @PostMapping("addDonation")
    public ResultVO<Object> addDonation(@RequestParam("pid") String pid,
                                        @RequestParam("donor") String donor,
                                        @RequestParam("donee") String donee,
                                        @RequestParam("money") double money
                                        ){
        DonateDO donateDO = new DonateDO(pid,donor,donee,money);
        String did = getUUID();
        donateDO.setDid(did);
        String dtime = getTime();
        donateDO.setDtime(dtime);
        donateService.addDonation(donateDO);
        return new ResultVO<>(200, "success", donateDO);
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
