package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.TestDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestMapper {
    @Select("select * from test")
    List<TestDO> selectAll();

}
