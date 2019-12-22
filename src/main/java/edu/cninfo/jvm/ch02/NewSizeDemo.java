package edu.cninfo.jvm.ch02;

/**
 * -Xmx20m -Xms20m -Xmm2m -XX:SurvivorRadio=2 -XX:+PrintGCDetails
 *
 */
public class NewSizeDemo {
    private static final int SIZE=1 *1024*1024;
    public static void main(String[] args) {
       byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[SIZE];
        }
    }
}
// -Xmx20m -Xms20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
//[GC (Allocation Failure) [PSYoungGen: 512K->504K(1024K)] 512K->512K(19968K), 0.0006856 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//        [GC (Allocation Failure) [PSYoungGen: 1016K->504K(1024K)] 1024K->632K(19968K), 0.0007008 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//        [GC (Allocation Failure) [PSYoungGen: 1016K->504K(1024K)] 1144K->804K(19968K), 0.0004854 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//        [GC (Allocation Failure) [PSYoungGen: 1016K->504K(1024K)] 1316K->892K(19968K), 0.0004588 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//        Heap
//        PSYoungGen      total 1024K, used 575K [0x00000000ffe80000, 0x0000000100000000, 0x0000000100000000)
//        eden space 512K, 13% used [0x00000000ffe80000,0x00000000ffe91dd8,0x00000000fff00000)
//        from space 512K, 98% used [0x00000000fff80000,0x00000000ffffe030,0x0000000100000000)
//        to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
//        ParOldGen       total 18944K, used 10628K [0x00000000fec00000, 0x00000000ffe80000, 0x00000000ffe80000)
//        object space 18944K, 56% used [0x00000000fec00000,0x00000000ff661100,0x00000000ffe80000)
//        Metaspace       used 3061K, capacity 4496K, committed 4864K, reserved 1056768K
//class space    used 329K, capacity 388K, committed 512K, reserved 1048576K

// -Xmx20m -Xms20m -Xmm2m -XX:SurvivorRadio=2 -XX:+PrintGCDetails
//[GC (Allocation Failure) [PSYoungGen: 1024K->504K(1536K)] 1024K->628K(19968K), 0.0006045 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//        [GC (Allocation Failure) [PSYoungGen: 1528K->504K(1536K)] 1652K->847K(19968K), 0.0008172 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//        Heap
//        PSYoungGen      total 1536K, used 711K [0x00000000ffe00000, 0x0000000100000000, 0x0000000100000000)
//        eden space 1024K, 20% used [0x00000000ffe00000,0x00000000ffe33cb8,0x00000000fff00000)
//        from space 512K, 98% used [0x00000000fff80000,0x00000000ffffe010,0x0000000100000000)
//        to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
//        ParOldGen       total 18432K, used 10583K [0x00000000fec00000, 0x00000000ffe00000, 0x00000000ffe00000)
//        object space 18432K, 57% used [0x00000000fec00000,0x00000000ff655d70,0x00000000ffe00000)
//        Metaspace       used 3175K, capacity 4496K, committed 4864K, reserved 1056768K
//class space    used 342K, capacity 388K, committed 512K, reserved 1048576K
