package edu.cninfo.tools.slf4j;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
/**
 * 比较 logger 插值与拼接字符串的性能
 * 参考: https://my.oschina.net/langxSpirit/blog/1799703
 */
public class LogTest {
    @Benchmark
    public static void printLoggerUserString() {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        for (int i = 0; i < 10; i++) {
            logger.info("hello : " + (Calendar.getInstance().getTime()));
        }
    }

    @Benchmark
    public static void printLogger() {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        for (int i = 0; i < 10; i++) {
            logger.info("hello : {}", (Calendar.getInstance().getTime()));
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LogTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
