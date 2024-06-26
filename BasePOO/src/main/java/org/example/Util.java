package org.example;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Util {
    private static Scanner scanner = new Scanner(System.in);
    public static <T> T askInput(String asked, Class<T> type) {
        while (true) {
            System.out.println(asked);
            try {
                T inputValue;
                String inputString = scanner.nextLine();
                // la classe String n'a pas de méthode valueOf
                if (!type.equals(String.class)) {
                    Method valueOf = type.getMethod("valueOf", String.class);
                    inputValue = type.cast(valueOf.invoke(null, inputString));
                } else {
                    inputValue = type.cast(inputString);
                }
                return inputValue;
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }
}
