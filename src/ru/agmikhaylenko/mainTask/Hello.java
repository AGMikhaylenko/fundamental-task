package ru.agmikhaylenko.mainTask;

import java.util.Scanner;

/**
 *  Класс, реализующий приветствовие любого пользователя при вводе его имени через командную строку.
 */
public class Hello {

    public static void main(String[] args) {
        Hello test = new Hello();
        test.sayHello();
    }

    public void sayHello(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello!, enter your name: ");
        System.out.println("Hello, " + sc.next() + "!");
        sc.close();
    }
}
