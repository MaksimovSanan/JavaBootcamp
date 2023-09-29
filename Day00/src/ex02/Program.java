package ex02;


import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int counter = 0;
        while((x = scanner.nextInt()) != 42){
            if(Program.CheckSimple(SumOfDigit(x))) ++counter;
        }
        System.out.println("Count of coffee-request – "+ counter);
    }

    static int SumOfDigit(int x) {
        int res = 0;
        while(x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    static boolean CheckSimple(int x) {
        int sqrt = (int)Math.ceil(Math.sqrt(x));
        boolean flag = true;
        for(int i = 2; i <= sqrt; ++i) {
            if(x%i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}