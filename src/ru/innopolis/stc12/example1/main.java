package ru.innopolis.stc12.example1;

public class main {
    public static void main(String[] args) {

        Object myArray[] = {0, 1, 5, 6, 7, 89};
        MathBox mathBox = new MathBox(myArray);
        mathBox.addItem(29);
        System.out.println(mathBox.summator());
    }
}
