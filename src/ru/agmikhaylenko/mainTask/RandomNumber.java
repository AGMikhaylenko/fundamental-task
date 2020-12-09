package ru.agmikhaylenko.mainTask;

import java.util.Scanner;


/**
 * Класс, реализующий вывод заданного количества случайных чисел с переходом и без перехода на новую строку
 */
public class RandomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount of numbers: ");
        int amount = sc.nextInt();
        sc.close();

        new RandomNumber().printRandomNumber(amount);
    }

    public void printRandomNumber(int amount) {
        int[] array = new int[amount];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }

        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println('\n');

        for (int element : array) {
            System.out.println(element);
        }
    }
}
