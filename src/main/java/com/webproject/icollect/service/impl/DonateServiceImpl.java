package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.DonateMapper;
import com.webproject.icollect.pojo.DonateDO;

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

    @Override
    public List<DonateDO> getDonationByProject(String pid) {
        return donateMapper.getDonationByProject(pid);
    }

    @Override
    public List<DonateDO> getDonationByDonor(String donor) {
        return donateMapper.getDonationByDonor(donor);
    }

    @Override
    public List<DonateDO> getDonationByDonee(String donee) {
        return donateMapper.getDonationByDonee(donee);
    }

    @Override
    public void addDonation(DonateDO donateDO) {
        donateMapper.addDonation(donateDO);
    }


    @Override
    public UserDO getUserToken(int id) {
        return donateMapper.findUserById(id);
    }

}
