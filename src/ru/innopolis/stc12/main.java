package ru.innopolis.stc12;

/*
* Написать класс MathBox , реализующий следующий функционал:

1.       Конструктор на вход получает массив Integer. Элементы не могут повторяться. Элементы массива внутри конструктора раскладываются в подходящую коллекцию (выбрать самостоятельно), являющуюся полем MathBox. Элементы должны отсортироваться

2.       Существует метод summator, возвращающий сумму всех элементов коллекции

3.       Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода. Метод возвращает коллекцию с результатами деления. Коллекция внутри mathbox при этом не меняется

4.       Необходимо правильно переопределить методы toString , hashCode, equals, чтобы можно было использовать MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap ). Выполнение контракта обязательно!

5.      Есть метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
* */


import java.util.Random;

public class main {
    public static void main(String[] args) {

        int[] myArray = new int[1000];//создаём массив
        for (int i = 0; i < 1000; i++) {//заполняем неповторяющимися элементами
            myArray[i] = i;
        }

        Random random = new Random();
        for (int i = myArray.length - 1; i > 0; i--) {//перемешиваем массив
            int j = random.nextInt(i + 1);
            int temp = myArray[j];
            myArray[j] = myArray[i];
            myArray[i] = temp;
        }

        MathBox mathBox = new MathBox(myArray);//конструктор с сортровкой внутри

        System.out.println(mathBox.summator());//суммируем элементы массива

        mathBox.searchAndRemoveItem(55);//удаляем элемент

        System.out.println(mathBox.splitter(2));//деление элементов
    }
}