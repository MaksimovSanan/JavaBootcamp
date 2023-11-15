package edu.school21.printer.logic;

import java.util.List;

public class OutputTerminal {
    public static void printTerminal(List<List<Boolean>> pixArray, char blackPixel, char whitePixel) {
        for (List<Boolean> booleans : pixArray) {
            for (Boolean pixel : booleans) {
                if (pixel) System.out.print(blackPixel);
                else System.out.print(whitePixel);
            }
            System.out.println();
        }
    }
}
