package edu.cninfo.effective.item10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 9999, "area code");
        rangeCheck(prefix, 9999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ":" + arg);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNumber == that.lineNumber;
    }

    /**
     * PhoneNumber做为HashMap的key时，get方法时间复杂度由0(lg(n)) 退化为O(n)
     *
     * @return
     */
//    @Override
//    public int hashCode() {
//        return 42;
//    }

    //    @Override
//    public int hashCode() {
//        return Objects.hash(areaCode, prefix, lineNumber);
//    }
    private int hashCode=0;

    /**
     * 避免重复计算hash值（没多大必要，hash计算耗时不大）
     * @return
     */
    @Override
    public int hashCode() {
        if (hashCode != 0) {
            return hashCode;
        }
        return Objects.hash(areaCode, prefix, lineNumber);
    }


    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(707, 867, 5309), "jenny");
        System.out.println(map.get(new PhoneNumber(707, 867, 5309)));

        long start = System.currentTimeMillis();
        Map<PhoneNumber, String> map2 = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            map.put(new PhoneNumber(i, 867, 5309), "jenny" + i);
        }
        System.out.println(map.get(new PhoneNumber(465, 867, 5309)));
        System.out.println("time: " + (System.currentTimeMillis() - start));

    }
}

