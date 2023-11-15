package ex01;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program {
    public static void main(String[] args) {
        try(BufferedReader BF1 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/ex01/" + args[0]));
            BufferedReader BF2 = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/ex01/" + args[1]))) {
            HashSet<String> poolStrings = new HashSet<>();
            HashMap<String, Integer> poolStrings1 = new HashMap<String, Integer>();
            HashMap<String, Integer> poolStrings2 = new HashMap<String, Integer>();

            String line;
            while((line = BF1.readLine()) != null) {
                for (String word : line.split(" ")) {
                    poolStrings1.put(word, poolStrings1.getOrDefault(word, 0) + 1);
                    poolStrings.add(word);
                }
            }

            while((line = BF2.readLine()) != null) {
                for (String word : line.split(" ")) {
                    poolStrings2.put(word, poolStrings2.getOrDefault(word, 0) + 1);
                    poolStrings.add(word);
                }
            }

            double numerator = 0;
            double denominator = 0;
            double denominatorA = 0;
            double denominatorB = 0;


            for(String word: poolStrings) {
                int countWordOnA = poolStrings1.getOrDefault(word, 0);
                int countWordOnB = poolStrings2.getOrDefault(word, 0);
                numerator += countWordOnA * countWordOnB;
                denominatorA += countWordOnA * countWordOnA;
                denominatorB += countWordOnB * countWordOnB;
            }
            denominator = Math.sqrt(denominatorA) *  Math.sqrt(denominatorB);

//            System.out.println(numerator);
//            System.out.println(denominator);
            System.out.printf("Similarity = %.2f\n", (numerator/denominator));

//            long numeratortmp = poolStrings.stream()
//                    .mapToLong(word -> poolStrings1.getOrDefault(word, 0) * poolStrings2.getOrDefault(word, 0))
//                    .sum();
//            System.out.println(numeratortmp);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
