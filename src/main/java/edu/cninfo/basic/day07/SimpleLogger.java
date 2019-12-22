package edu.cninfo.basic.day07;

/**
 * 在代码中使用Lambda表达式
 */
public class SimpleLogger {
    public static String expensiveOperation() {
        return "expensiveOperation";
    }

    public static void main(String[] args) {

        Logger logger = new Logger();
        logger.setDebugEnabled(true);
        /**
         * 1.先调用logger.isDebugEnabled()
         * 2.打印日志
         */
        if (logger.isDebugEnabled()) {
            logger.debug("Look at this " + expensiveOperation());
        }

        /**
         * 2.使用此方法，不需要每次都调用 logger.isDebugEnabled() 先判断logger级别，再打印日志
         */
        logger.debug(() -> "Look at this " + expensiveOperation());
    }
}
