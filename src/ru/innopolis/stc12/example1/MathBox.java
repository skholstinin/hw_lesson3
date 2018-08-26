package ru.innopolis.stc12.example1;

import java.util.ArrayList;
import java.util.List;

public class MathBox {

    List<Object> myList = new ArrayList<>();

    public MathBox(Object array[]) {
        for (int i = 0; i < array.length; i++) {
            myList.add(array[i]);//TreeSet добавит в себя только уникальные значения и отсортирует их
        }

    }

    public void addItem(Object o) {
        myList.add(o);

    }

    public int summator() {
        //Поэтому приводим его к ArrayList.
        int sum = 0;
        for (int i = 0; i < myList.size(); i++) {
            try {
                sum += (int) myList.get(i);
            } catch (ClassCastException e) {

                System.out.println("Error ClassCastException");
            }
        }
        return sum;
    }
}
