package edu.cninfo.jvm.ch02;

/**
 * -XX:PrintGC
 */
public class LocalVarGc {
    private final int SIZE = 1024 * 1024 * 6;

    public void localvarGc1() {
        byte[] a = new byte[SIZE];
        System.gc();
    }

    public void localvarGc2() {
        byte[] a = new byte[SIZE];
        a = null;
        System.gc();
    }

    public void localvarGc3() {
        {
            byte[] a = new byte[SIZE];
        }
        System.gc();
    }

    public void localvarGc4() {
        {
            byte[] a = new byte[SIZE];
        }
        int c=10;
        System.gc();
    }

    public void localvarGc5(){
        localvarGc1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGc ins = new LocalVarGc();
//        ins.localvarGc1();
//        ins.localvarGc2();
//        ins.localvarGc3();
        ins.localvarGc4();
//        ins.localvarGc5();
    }
}
