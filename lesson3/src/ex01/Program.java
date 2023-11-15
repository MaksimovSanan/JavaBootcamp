package ex01;

public class Program {

    public static void main(String[] args) {

        int count = 3;
        for(String option: args) {
            String[] optionParameters = option.split("=");
            if(optionParameters[0].equals("--count")) {
                try {
                    count = Integer.parseInt(optionParameters[1]);
                }
                catch(Exception e) {
                    System.out.println("Illegal ergument");
                }
            }
        }

        Producer p = new Producer(count);
        Thread t1 = new Thread(()-> {
                try {
                    p.EggProducer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        });

        Thread t2 = new Thread(()-> {
                try {
                    p.HenProducer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        });

        t2.start();
        t1.start();
    }
}



