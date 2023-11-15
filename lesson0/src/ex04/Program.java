package ex04;

import java.util.Scanner;

public class Program{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int [] arr = new int[65536];
//
        for(int i = 0; i < line.length(); ++i) {
            ++arr[line.charAt(i)];
        }


        char [] OutputArr = new char[11];

        for(int i = 0; i < arr.length; ++i) {
            for(int j = OutputArr.length - 2; j > -1; --j) {
                if(arr[i] > arr[OutputArr[j]]) {
                    OutputArr[j + 1] = OutputArr[j];
                    OutputArr[j] = (char)i;
                }
                else break;
            }
        }

        double proportion = arr[OutputArr[0]] / 10.;

        for(int i =0; i < 11; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (arr[OutputArr[j]] / proportion >= 11 - i) System.out.print("  # ");
                else if (OutputArr[i] != 0 && (arr[OutputArr[j]] / proportion + 1 >= 11 - i)) System.out.printf("%3d ", arr[OutputArr[j]]);
            }
            System.out.println();
        }

        for(int i = 0; i < 10;++i) {
            if(OutputArr[i] != 0) System.out.print("  " + OutputArr[i] + " ");
        }
    }
}