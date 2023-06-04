package org.multithreading.ParallelStreams;

public class ParallelStream {

    public static boolean isPrime(long num) {
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num%2 == 0) return false;

        long maxDivisor = (long) Math.sqrt(num);

        for(int i = 3; i<maxDivisor; i += 2) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
