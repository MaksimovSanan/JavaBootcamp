package edu.school21.printer.logic;

import com.diogonunes.jcolor.Attribute;

import java.awt.*;
import java.util.List;
import java.awt.Color;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.BACK_COLOR;
import static com.diogonunes.jcolor.Attribute.TEXT_COLOR;

public class OutputTerminal {

    public static Color getColorByName(String colorName) {
        try {
            java.lang.reflect.Field field = Color.class.getField(colorName);
            return (Color) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void printTerminal(List<List<Boolean>> pixArray, String blackPixel, String whitePixel) {
        try {
            Color bcolor = getColorByName(blackPixel);
            Color wcolor = getColorByName(whitePixel);

            Attribute bbkgColor = BACK_COLOR(bcolor.getRed(), bcolor.getGreen(), bcolor.getBlue());
            Attribute wbkgColor = BACK_COLOR(wcolor.getRed(), wcolor.getGreen(), wcolor.getBlue());

            for (List<Boolean> booleans : pixArray) {
                for (Boolean pixel : booleans) {
                    if (pixel) System.out.print(colorize(" ", bbkgColor));
                    else System.out.print(colorize(" ", wbkgColor));
                }
                System.out.println();
            }
        }
        catch (RuntimeException e) {
            System.out.println("Invalid color");
        }
    }
}
