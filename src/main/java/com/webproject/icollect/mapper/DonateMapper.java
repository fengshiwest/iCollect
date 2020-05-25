package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.DonateDO;
<<<<<<< HEAD
import com.webproject.icollect.pojo.UserDO;
=======
>>>>>>> 161036aa6be2789df3ec10102fbe656a648337dc
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wan Yu on 2020/5/18
 */

@Mapper
@Repository
public interface DonateMapper {

    @Select("select * from Donate where pid=#{pid}")
    List<DonateDO> getDonationByProject(String pid);

    @Select("select * from Donate where donor=#{donor}")
    List<DonateDO> getDonationByDonor(String donor);

    @Select("select * from Donate where donee=#{donee}")
    List<DonateDO> getDonationByDonee(String donee);

    @Insert("insert into Donate(did,pid,donor,donee,money,dtime) values(#{did},#{pid},#{donor},#{donee},#{money},#{dtime})")
    void addDonation(DonateDO donateDO);
<<<<<<< HEAD

    @Select("select * from User where uid=#{id}")
    UserDO findUserById(int id);
=======
>>>>>>> 161036aa6be2789df3ec10102fbe656a648337dc
}
