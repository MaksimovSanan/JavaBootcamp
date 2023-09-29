package ex03;

import java.util.Scanner;

public class Program {

    static int counter;

    public static void main(String[] args) {
        int weeks = GetWeek();

        PrintWeek(weeks);
    }

    static int GetWeek() {
        Scanner scanner = new Scanner(System.in);

        int res = 0;
        String line = scanner.nextLine();
        while(!line.equals("42")) {
            if (!line.equals("Week " + (counter + 1))) {
                System.out.println("IllegalArgument");
                System.exit(-1);
            }

            int min = scanner.nextInt();
            for (int i = 0; i < 4; ++i) {
                int tmp = scanner.nextInt();
                min = Math.min(tmp, min);
            }
            res += min * Math.pow(10, counter);
            ++counter;
            scanner.nextLine();
            line = scanner.nextLine();
        }
        return res;
    }

    static void PrintWeek(int weeks){
        for(int i = 0; i < counter; ++i) {
            System.out.print("Week " + (i + 1) + " ");
            for(int j = 0; j < (weeks%10); ++j) {
                System.out.print("=");
            }
            System.out.println(">");
            weeks /= 10;
        }
    }
}