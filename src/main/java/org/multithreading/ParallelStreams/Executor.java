package org.multithreading.ParallelStreams;

import java.util.stream.IntStream;

public class Executor {
    public static void main(String[] args) {

        // Sequential Stream
        long currentTime = System.currentTimeMillis();
        long numOfPrimes = IntStream.rangeClosed(2,Integer.MAX_VALUE / 100)
                .filter(ParallelStream::isPrime)
                .count();
        System.out.println("Number of Primes: " + numOfPrimes);
        System.out.println("Time taken with Sequential Approach: "+(System.currentTimeMillis() - currentTime) + "ms");

        // Parallel Stream
        currentTime = System.currentTimeMillis();
        numOfPrimes = IntStream.rangeClosed(2,Integer.MAX_VALUE / 100)
                .parallel()
                .filter(ParallelStream::isPrime)
                .count();
        System.out.println("Number of Primes: " + numOfPrimes);
        System.out.println("Time taken with Parallel Approach: "+(System.currentTimeMillis() - currentTime) +"ms");
    }
}
