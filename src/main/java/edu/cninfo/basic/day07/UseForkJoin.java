package edu.cninfo.basic.day07;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class UseForkJoin extends RecursiveTask<Integer> {
    private static final int RANGE = 2;
    private final int begin;
    private final int end;

    public UseForkJoin(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        int sum = 0;
        if (end - begin <= RANGE) {
            for (int i = begin; i <= end; i++) {
                sum += i;
            }
        } else {
            int mid = (begin + end) / 2;
            UseForkJoin leftForkJoin = new UseForkJoin(begin, mid);
            UseForkJoin rightForkJoin = new UseForkJoin(mid + 1, end);

            leftForkJoin.fork();
            rightForkJoin.fork();

            Integer leftResult = leftForkJoin.join();
            Integer rightResult = rightForkJoin.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        UseForkJoin useForkJoin = new UseForkJoin(1,10000);
        final ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<Integer> result = forkJoinPool.submit(useForkJoin);
        System.out.println("最终执行结果为：" + result.get());
    }
}
