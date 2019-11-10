package edu.cninfo.basic.day03;

/**
 * @author chenxinwei
 * @date 2019/11/6 16:19
 **/
public class WeekEnumTest {
    public static void main(String[] args) {
        for (WeekEnum value : WeekEnum.values()) {
            System.out.println(value.toString());
        }

        System.out.println("ordinal: " + WeekEnum.THU.ordinal());

        WeekEnum thu = WeekEnum.THU;
        switch (thu) {
            case MON:
                System.out.println("今天星期一");
                break;
            case THU:
                System.out.println("今天星期二");
                break;
            default:
                System.out.println(thu);
                break;
        }
    }

    public static int eval(Operation op, int first, int second) {
        int result = 0;
        switch (op) {
            case ADD:
                result = first + second;
                break;
            case SUBTRACE:
                result = first - second;
                break;
            case MULTIPLY:
                result = first * second;
                break;
            case DIVIDE:
                result = first / second;
                break;
        }
        return result;
    }
}
