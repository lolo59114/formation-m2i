package org.example.util;


import java.util.List;

public class DisplayManager {
    public static <T> void displayList(List<T> myList, Class<T> type) {
        if(myList == null || myList.isEmpty()) {
            System.out.println("Aucun(e) " + type.getSimpleName() + " à afficher.");
            return;
        }

        for(T element : myList) {
            System.out.println(element);
        }
    }
}

