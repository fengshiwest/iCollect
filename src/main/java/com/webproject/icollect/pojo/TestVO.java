package com.webproject.icollect.pojo;

import java.util.List;

public class TestVO {

    private List<TestDO> testList;
    private int page;
    private int size;

    public TestVO(List<TestDO> testList, int page) {
        this.testList = testList;
        this.page = page;
        this.size = testList.size();
    }

    public List<TestDO> getTestList() {
        return testList;
    }

    public void setTestList(List<TestDO> testList) {
        this.testList = testList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return testList.size();
    }

    public void setSize(int size) {
        this.size = size;
    }
}
