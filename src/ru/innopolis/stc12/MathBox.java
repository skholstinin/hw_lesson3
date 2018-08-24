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

    private final List<Integer> myList = new ArrayList<>();

    private final SortedSet<Integer> myTreeSet = new TreeSet<>();

    /*public MathBox(int array[]) {//конструктор для обычного массива ортировкой внутри
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
    }*/


    public MathBox(int array[]) {//конструктор для TreeSet

        for (int i = 0; i < array.length; i++) {
            myTreeSet.add(array[i]);//TreeSet добавит в себя только уникальные значения и отсортирует их
        }
    }


    public int summator() {
        List<Integer> tempTreeSet = new ArrayList<Integer>(myTreeSet);//TreeSet сортирует и не даёт зписать одинаковые элементы.Как получить доступ к элементам-пока непонятно.
        //Поэтому приводим его к ArrayList.
        int sum = 0;
        for (int i = 0; i < tempTreeSet.size(); i++) {
            sum += (int) tempTreeSet.get(i);
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
        myTreeSet.remove(item);
    }

    public List splitter(int divider) {
        List<Integer> ArrayList = new ArrayList<Integer>(myTreeSet);
        List localList = new ArrayList();
        for (int i = 0; i < ArrayList.size(); i++) {
            localList.add(i, (int) ArrayList.get(i) / divider);
        }
        return localList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(myList, mathBox.myList) &&
                Objects.equals(myTreeSet, mathBox.myTreeSet);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "myList=" + myList +
                ", myTreeSet=" + myTreeSet +
                '}';
    }
}
