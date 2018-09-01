package ru.innopolis.stc12;

import java.util.*;

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

    private final SortedSet<Integer> numberTreeSet = new TreeSet<>();

    public MathBox(ArrayList<Integer> array) {//конструктор для TreeSet
        System.out.println("Constructor");
        numberTreeSet.addAll(array);//TreeSet добавит в себя только уникальные значения и отсортирует их
        System.out.println(numberTreeSet);

    }

    public void addItem(Integer item) {
        numberTreeSet.add(item);
    }


    public int summator() {
        Iterator<Integer> iterator = numberTreeSet.iterator();
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    public void bubleSort(int arr[]) {//только для конструктора с ArrayList внутри
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
        numberTreeSet.remove(item);
    }

    public List splitter(int divider) {
        ArrayList<Integer> localList = new ArrayList();
        for (Integer s : numberTreeSet) {
            localList.add(s / divider);
            System.out.println(localList);
        }
        return localList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(numberTreeSet, mathBox.numberTreeSet);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "MathBox{" +
                ", myTreeSet=" + numberTreeSet +
                '}';
    }
}
