package ru.agmikhaylenko.mainTask;

/**
 * Класс, реализующий ввод целых чисел как аргументы командной строки, подсчет их сумму (произведение) и вывод результат на консоль
 * Run -> Edit Configurations -> Program Arguments
 */
public class SumAndMultiplication {

    public static void main(String[] args) {
        SumAndMultiplication test = new SumAndMultiplication();

        System.out.println("Sum = " + test.getSumOfArray(getIntegerArrayFromString(args)));
        System.out.println("Multiplication = " + test.getMultiplicationOfArray(getIntegerArrayFromString(args)));
    }

    public static int[] getIntegerArrayFromString(String[] arrayString) {
        int[] arrayInteger = new int[arrayString.length];

        for (int i = 0; i < arrayString.length; i++) {
            arrayInteger[i] = Integer.valueOf(arrayString[i]);
        }

        return arrayInteger;
    }

    public int getSumOfArray(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    public int getMultiplicationOfArray(int[] array) {
        int multi = 1;
        for (int element : array) {
            multi *= element;
        }
        return multi;
    }
}
