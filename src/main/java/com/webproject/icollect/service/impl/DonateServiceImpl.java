package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.DonateMapper;
import com.webproject.icollect.mapper.ProjectMapper;
import com.webproject.icollect.pojo.DonateDO;

import com.webproject.icollect.pojo.ProjectDO;
import com.webproject.icollect.pojo.UserDO;

import com.webproject.icollect.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wan Yu on 2020/5/18
 */
@Service
public class DonateServiceImpl implements DonateService {

    @Autowired
    private DonateMapper donateMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<DonateDO> getDonationByProject(String pid) {
        return donateMapper.getDonationByProject(pid);
    }

    @Override
    public List<DonateDO> getDonationByDonor(int donor) {
        return donateMapper.getDonationByDonor(donor);
    }

    @Override
    public List<DonateDO> getDonationByDonee(int donee) {
        return donateMapper.getDonationByDonee(donee);
    }

    @Override
    public void addDonation(DonateDO donateDO) {
        ProjectDO projectDO = projectMapper.getProjectInfo(donateDO.getPid());
        /* - update current money in project
           - finish project if reach the target money
         */
        double currentMoney = projectDO.getCurrentMoney();
        if((currentMoney += donateDO.getMoney()) >= projectDO.getTargetMoney())
            projectMapper.finishProject(true, projectDO.getPid());
        projectMapper.updateMoney(currentMoney, projectDO.getPid());
        // get the real donee of project
        donateDO.setDonee(projectDO.getAuthorID());
        donateMapper.addDonation(donateDO);
    }

    @Override
    public UserDO getUserToken(int id) {
        return donateMapper.findUserById(id);
    }

}
