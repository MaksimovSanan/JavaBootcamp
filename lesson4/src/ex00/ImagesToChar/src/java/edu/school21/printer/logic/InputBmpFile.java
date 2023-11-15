package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class InputBmpFile {
    public static List<List<Boolean>> ReadBMPFile(String BMPPath) throws FileNotFoundException {
        try {
            BufferedImage image = ImageIO.read((new File(BMPPath)));
            List<List<Boolean>> res = new ArrayList<>();

            int width = image.getWidth();
            int height = image.getHeight();

            for (int y = 0; y < height; y++) {
                List<Boolean> tmp = new ArrayList<>();
                res.add(tmp);
                for (int x = 0; x < width; x++) {
                    int pixel = image.getRGB(x, y);
                    // Проверка значения пикселя (здесь можно настроить условие)
                    boolean isBlack = (pixel & 0x00FFFFFF) == 0; // Пример: проверка на черный цвет

                    res.get(y).add(isBlack);
                }
            }
            return res;
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
