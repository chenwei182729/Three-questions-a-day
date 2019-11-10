package edu.cninfo.basic.day01.mybatis.vo;

public class Duck {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    public Duck select(String key){
        return new Duck("d");
    }
    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                '}';
    }
}
