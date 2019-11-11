package edu.cninfo.basic.day03;

public class SwitchTest {
    public static void main(String[] args) {
        final String s1 = "!~";
        final String s2 = "\"_";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());


        String s = s2;
        switch (s2) {
            case s1:
                System.out.println(s1);
                break;
            case s2:
                System.out.println(s2);
                break;
        }
    }
}