package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if(x < 3) {
            System.out.println("Illegal Argument");
            System.exit(-1);
        }
        int sqrt = (int)Math.ceil(Math.sqrt(x));
        int counter = 0;
        boolean flag = true;
        for(int i = 2; i <= sqrt; ++i) {
            ++counter;
            if(x%i == 0) {
                flag = false;
                break;
            }
        }
        System.out.println(flag + " " + counter);
    }

}