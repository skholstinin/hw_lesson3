package ru.innopolis.stc12;

import java.util.ArrayList;
import java.util.List;

/*
* Написать класс MathBox , реализующий следующий функционал:

1.       Конструктор на вход получает массив Integer. Элементы не могут повторяться.
 Элементы массива внутри конструктора раскладываются в подходящую коллекцию (выбрать самостоятельно), являющуюся полем MathBox.
 Элементы должны отсортироваться

2.       Существует метод summator, возвращающий сумму всех элементов коллекции

3.       Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
 являющийся аргументом метода. Метод возвращает коллекцию с результатами деления.
Коллекция внутри mathbox при этом не меняется

4.       Необходимо правильно переопределить методы toString , hashCode, equals, чтобы можно было использовать
 MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap ).
Выполнение контракта обязательно!

5.      Есть метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
* */
public class MathBox {

    private List<Integer> myList = new ArrayList<>();


    public MathBox(int array[]) {


        for (int i = 0; i < array.length; i++) {
            myList.add(i, array[i]);
        }
        System.out.println(myList);
        myList.clear();

        bubleSort(array);
        for (int i = 0; i < array.length; i++) {
            myList.add(i, array[i]);
        }
        System.out.println(myList);
    }

    public int summator() {
        int sum = 0;
        int i;
        for (i = 0; i < myList.size(); i++) {
            sum += (int) myList.get(i);
        }
        return sum;
    }

    public void bubleSort(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public void searchAndRemoveItem(Integer item) {
        myList.remove(item);
    }

    public List splitter(int divider) {
        List localList = new ArrayList();
        for (int i = 0; i < myList.size(); i++) {
            localList.add(i, (int) myList.get(i) / divider);
        }

        return localList;
    }
}
