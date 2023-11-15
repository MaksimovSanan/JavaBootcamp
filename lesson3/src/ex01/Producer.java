package ex01;

public class Producer {
    private volatile boolean flag;
    private final int count;

    public Producer(int count) {
        this.count = count;
    }

    public synchronized void HenProducer() throws InterruptedException {
        for (int i = 0; i < count; i++) {
//            System.out.println(Thread.currentThread().getName() + " Hen");
            if(!flag) {
//                System.out.println(Thread.currentThread().getName() + " wait ");
                wait();
//                System.out.println(Thread.currentThread().getName() + " Hen ne slip ");
            }
            System.out.println("Hen");
            flag = false;
            notifyAll();
        }
    }

    public synchronized void EggProducer() throws InterruptedException {
        for (int i = 0; i < count; i++) {
//            System.out.println(Thread.currentThread().getName() + " EGG");
            if(flag) {
//                System.out.println(Thread.currentThread().getName() + "wait");
            wait();
//                System.out.println(Thread.currentThread().getName() + " EGG ne slip ");
            }
            System.out.println("Egg");
            flag = true;
            notifyAll();
        }
    }
}
