package edu.cninfo.basic.day01.mybatis.vo;

public class Turkey {
    private String name;

    public Turkey(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Turkey{" +
                "name='" + name + '\'' +
                '}';
    }
}
