package ex02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadSummator extends Thread{
    private CountDownLatch latch;
    private final int[] arrayInt;
    private final int start;
    private final int stop;

    private int sum;
    public ThreadSummator(int[] arrayInt, int start, int stop,CountDownLatch latch) {
        this.latch = latch;
        this.arrayInt = arrayInt;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void run() {
        for(int i = start;i < stop; ++i) {
            sum += arrayInt[i];
        }
        latch.countDown();
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "from " + start +
                " to " + (stop - 1) +
                " sum is " + sum;
    }
}
