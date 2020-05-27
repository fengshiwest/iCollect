package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.UserDO;
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

    @Select("select * from Donate natural join (select username as donorName, id as donor from User) as Donor " +
            "natural join (select username as doneeName, id as donee from User) as Donee " +
            "natural join (select pid, name as projectName from Project where pid=#{pid}) as Project")
    List<DonateDO> getDonationByProject(String pid);

    @Select("select * from Donate natural join (select username as donorName, id as donor from User where id=#{donor}) as Donor " +
            "natural join (select username as doneeName, id as donee from User) as Donee " +
            "natural join (select pid, name as projectName from Project) as Project")
    List<DonateDO> getDonationByDonor(int donor);

    @Select("select * from Donate natural join (select username as donorName, id as donor from User) as Donor " +
            "natural join (select username as doneeName, id as donee from User where id=#{donee}) as Donee " +
            "natural join (select pid, name as projectName from Project) as Project")
    List<DonateDO> getDonationByDonee(int donee);

    @Insert("insert into Donate(did,pid,donor,donee,money,dtime) values(#{did},#{pid},#{donor},#{donee},#{money},#{dtime})")
    void addDonation(DonateDO donateDO);

    @Select("select * from User where id=#{id}")
    UserDO findUserById(int id);
}
