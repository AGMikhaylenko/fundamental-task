package ru.agmikhaylenko.mainTask;

import java.util.InputMismatchException;

/**
 * Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
 * Осуществить проверку корректности ввода чисел.
 * Run -> Edit Configurations -> Program Arguments
 */
public class ConvertorMonth {

    public static void main(String[] args) {

        int numberOfMonth = 0;
        try {
            numberOfMonth = Integer.valueOf(args[0]);
        } catch (InputMismatchException inputException) {
            System.out.println("Value is not a digit!");
            return;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return;
        }

        if (numberOfMonth <= 0 || numberOfMonth > 12) {
            System.out.println("Value of number is not correct!");
        } else {
            System.out.println(getMonthByNumber(numberOfMonth));
        }
    }

    public static String getMonthByNumber(int numberOfMonth) {
        String[] namesOfMonth = {"January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"};
        return namesOfMonth[numberOfMonth - 1];
    }

}
