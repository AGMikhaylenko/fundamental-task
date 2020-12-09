package ru.agmikhaylenko.mainTask;

import java.util.Arrays;


/**
 * Класс, реализующий отображение в окне консоли аргументов командной строки в обратном порядке
 * Run -> Edit Configurations -> Program Arguments
 */
public class ReverseArguments {
    public static void main(String[] args) {
        ReverseArguments test = new ReverseArguments();
        test.reverseArray(args);
    }

    public void reverseArray(String[] args) {
        String buffer = null;
        for (int i = 0; i < args.length / 2; i++) {
            buffer = args[i];
            args[i] = args[args.length - 1 - i];
            args[args.length - 1 - i] = buffer;
        }

        System.out.println(Arrays.toString(args));
    }

}
