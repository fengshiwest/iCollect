package com.webproject.icollect.service;

import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.UserDO;

import java.util.List;

/**
 * Created by Wan Yu on 2020/5/18
 */
public interface DonateService {

    List<DonateDO> getDonationByProject(String pid);

    List<DonateDO> getDonationByDonor(String donor);

    List<DonateDO> getDonationByDonee(String donee);

    void addDonation(DonateDO donateDO);

    UserDO getUserToken(int id);
}
