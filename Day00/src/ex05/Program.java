package ex05;

/*
John
Mike
ABOBA
.
2 MO
4 WE
.
Mike 2 28 NOT_HERE
John 4 9 HERE
Mike 4 9 HERE
ABOBA 4 16 HERE
.
 */

import java.util.Scanner;

public class Program {

    static String[] Week = {"TU", "WE", "TH", "FR", "SA", "SU", "MO"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] students = new String[10];
        for (int i = 0; i < 10; ++i) {
            students[i] = scanner.nextLine();
            if (students[i].equals(".")) break;
        }

        String[] classes = new String[10];
        int ClassesPerWeek = -1;
        for (int i = 0; i < 10; ++i) {
            classes[i] = scanner.nextLine();
            ++ClassesPerWeek;
            if (classes[i].equals(".")) break;
        }

        int[][][] attendance = new int[10][5][7];

        for (int i = 0; i < 10 * 10 * 5; ++i) {
            String attendanceRecord = scanner.nextLine();
            if (attendanceRecord.equals(".")) break;
            String[] parts = attendanceRecord.split(" ");
            String name = parts[0];
            String time = parts[1];
            int day = Integer.parseInt(parts[2]);
            boolean status = parts[3].equals("HERE");
            for (int student = 0; student < students.length; ++student) {
                if (students[student].equals(".")) break;
                if (students[student].equals(name)) {
                    int week = (day + 2) / 7;
                    if (status) {
                        attendance[student][week][(day + 3) % 7] = 1;
                    } else {
                        attendance[student][week][(day + 3) % 7] = -1;
                    }
                }
            }
        }

        System.out.print("          ");
        for (int i = 0; i < 30; ++i) {
            for (String lesson : classes) {
                if (lesson.equals(".")) break;
                String[] parts = lesson.split(" ");
                if (Week[(i) % 7].equals(parts[1])) {
                    System.out.printf(parts[0] + ":00 " + parts[1] + "%3d" + "|", (i + 1));
                }
            }
        }
        System.out.println();

        for (int i = 0; i < students.length; ++i) {
            if (students[i].equals(".")) break;
            System.out.printf("%10s", students[i]);
            for (int day = 0; day < 30; ++day) {

                for (String lesson : classes) {
                    if (lesson.equals(".")) break;
                    String[] parts = lesson.split(" ");
                    if (Week[(day) % 7].equals(parts[1])) {
                        ++day;
                        int week = (day + 2) / 7;
                        if (attendance[i][week][(day + 3) % 7] == 1)
                            System.out.printf("%10d|", 1);
                        else if (attendance[i][week][(day + 3) % 7] == -1)
                            System.out.printf("%10d|", -1);
                        else System.out.print("          |");
                    }
                }
            }
            System.out.println();
        }
    }
}