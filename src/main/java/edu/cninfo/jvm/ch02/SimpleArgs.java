package edu.cninfo.jvm.ch02;

/**
 * 虚拟机参数： -Xmx32m
 */
public class SimpleArgs {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("参数" + (i + 1) + ":" + args[i]);
        }
        System.out.println("-Xms" + Runtime.getRuntime().maxMemory() / 1000 / 1000 + "M");
    }
}
