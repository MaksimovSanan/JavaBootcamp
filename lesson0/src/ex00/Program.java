package ex00;


import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int res = 0;
        for(int i = 0; i < 6; ++i) {
            res += x % 10;
            x /= 10;
        }
        System.out.println(res);
    }
}
