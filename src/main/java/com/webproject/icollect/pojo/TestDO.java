package com.webproject.icollect.pojo;

import org.springframework.context.annotation.Bean;


public class TestDO {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "TestDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
