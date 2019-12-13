package edu.cninfo.concurrency.ch01;

 final class PrimeUtil {
    private PrimeUtil(){
        throw new RuntimeException("can't create PrimeUtil Class");
    }
     protected static boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        long nn = (long) Math.sqrt(number) + 1;
        for (long i = 2; i < nn; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
