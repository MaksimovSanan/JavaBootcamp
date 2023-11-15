package ex00;

public class Program {
    public static void main(String[] args) {
        Thread printHen = new Thread(() -> {
            for (int i = 0; i < 51; i++) {
                System.out.println("Hen");
            }
        });

        Thread printEgg = new Thread(() -> {
            for (int i = 0; i < 51; i++) {
                System.out.println("Egg");
            }
        });

        printHen.start();
        printEgg.start();
        try{
            printHen.join();
            printEgg.join();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Human");
        }
    }
}

