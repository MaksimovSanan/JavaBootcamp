package ex02;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class Program {

    private static int[] arrayInt;
    private static int arraySize = 13;
    private static int threadsCount = 3;
    private static int sum;

    public static void main(String[] args) {
        parseOptions(args);

        arrayInt = new int[arraySize];

        ThreadLocalRandom TLR = ThreadLocalRandom.current();
        for(int i = 0; i < arraySize; ++i) {
            arrayInt[i] = TLR.nextInt(1001);
//            arrayInt[i] = 1;
        }

        System.out.println("Sum: " + Arrays.stream(arrayInt).sum());

        ThreadSummator[] threads = new ThreadSummator[threadsCount];
        CountDownLatch latch = new CountDownLatch(threadsCount);
        for (int i = 0; i < threadsCount; ++i) {
//            System.out.println("start = " + i * (arraySize / threadsCount + ((arraySize % threadsCount > 0)? 1 : 0)));
//            System.out.println("end = " + Math.min((i + 1) * (arraySize / threadsCount + ((arraySize % threadsCount > 0)? 1 : 0)), arraySize));
            threads[i] = new ThreadSummator(arrayInt, i * (arraySize / threadsCount + ((arraySize % threadsCount > 0)? 1 : 0)),
                    Math.min((i + 1) * (arraySize / threadsCount + ((arraySize % threadsCount > 0)? 1 : 0)), arraySize), latch);
            threads[i].start();
        }


        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < threadsCount; i++) {
            System.out.println("Thread "+ (i+1) + ": " + threads[i].toString());
            sum += threads[i].getSum();
        }
        System.out.println("Sum by threads: " + sum);
    }
    private static void parseOptions(String[] args) {
        for(String option: args) {
            String[] optionsParam = option.split("=");
            switch (optionsParam[0]) {
                case "--arraySize":
                    try{
                        arraySize = Integer.parseInt(optionsParam[1]);
                    }
                    catch(Exception e) {
                        System.err.println("Illegal Argument: " + option);
                        return;
                    }
                case "--threadsCount":
                    try{
                        threadsCount = Integer.parseInt(optionsParam[1]);
                    }
                    catch(Exception e) {
                        System.err.println("Illegal Argument: " + option);
                        return;
                    }
            }
        }
    }
}
