package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> minerTask = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while (!name.equals("stop")){
            int num = Integer.parseInt(scanner.nextLine());

                if (minerTask.containsKey(name)){
                    int secondNum = minerTask.get(name);
                    minerTask.put(name, secondNum + num);
                }else {
                    minerTask.put(name, num);
                }

                name = scanner.nextLine();
        }
        minerTask.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
