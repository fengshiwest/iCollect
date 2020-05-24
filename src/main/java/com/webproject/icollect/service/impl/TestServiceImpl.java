package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.TestMapper;
import com.webproject.icollect.pojo.TestDO;
import com.webproject.icollect.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestDO> selectAll() {
        return testMapper.selectAll();
    }
}
