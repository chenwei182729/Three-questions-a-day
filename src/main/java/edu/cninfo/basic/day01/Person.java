package edu.cninfo.basic.day01;

import java.util.Objects;

public class Person {
    private int age;
    private String username;
    private String address;

    public Person(int age, String username, String address) {
        this.age = age;
        this.username = username;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String result = "username:" + username + ",address:" + address + ",age:" + age;
        return result;
    }

    public void showInfo() {
        String result = "username:" + username + ",address:" + address + ",age:" + age;
        System.out.println(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(username, person.username) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, username, address);
    }
}
