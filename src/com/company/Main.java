package com.company;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToDouble(Double ::parseDouble)
                .toArray();

        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (double i = 0; i <numbers.length ; i++) {
            if (!counts.containsKey(numbers[(int) i])){
                counts.put(numbers[(int) i], 0);
            }
            counts.put(numbers[(int) i], counts.get(numbers[(int) i]) + 1);
        }
        for (Map.Entry<Double, Integer> entry : counts.entrySet()){
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
