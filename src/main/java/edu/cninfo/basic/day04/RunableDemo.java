package edu.cninfo.basic.day04;

public class RunableDemo {
    private static Integer value = 10;
    private static Integer integerValue;

    static {
        tryImplementation(RunableDemo::divideByZero);
        tryImplementation(RunableDemo::divideByTwo);
    }

    public static synchronized void divideByZero() {
        setValue(0);
    }

    public static synchronized void divideByTwo() {
        setValue(2);
    }

    private static void tryImplementation(Runnable runnable) {
        if (value == null) {
            try {
                runnable.run();
            } catch (Throwable t) {
                // ignore
            }
        }
    }

    private static void setValue(int val) {
        try {
            integerValue = value / val;
        } catch (Throwable t) {
            throw new RuntimeException("divide by zero");
        }
    }

    public static void main(String[] args) {
        RunableDemo.divideByZero();
//        System.out.println(RunableDemo.integerValue);
    }
}
