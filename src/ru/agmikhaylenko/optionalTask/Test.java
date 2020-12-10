package ru.agmikhaylenko.optionalTask;

import java.util.Arrays;

/**
 * Задание. Ввести n чисел с консоли.
 *
 * 1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
 *
 * 2.     Вывести числа в порядке возрастания (убывания) значений их длины.
 *
 * 3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
 *
 * 4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
 *
 * 5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
 *
 * 6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
 *
 * 7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */
public class Test {

    Number[] arrayNumber;
    double avgLength;

    public static void main(String[] args) {
        Test test = new Test();
        test.go(args);
    }

    public void go(String[] args) {
        arrayNumber = getArrayNumberByString(args);
        avgLength = getAvgLength();

        System.out.println("===Task 7===");
        printFirstDifferentDigits();
        System.out.println("===Task 6===");
        printFirstGrowthDigits();
        System.out.println("===Task 5===");
        printCountOnlyEvenDigits();
        System.out.println("===Task 3===");
        printNumberWithSmallLength();
        printNumberWithBigLength();
        System.out.println("===Task 2===");
        Arrays.sort(arrayNumber, new BitDepthComparator());
        System.out.println(Arrays.toString(arrayNumber));
        System.out.println("===Task 1===");
        if (arrayNumber.length != 0) {
            System.out.println("Самое короткое число: " + arrayNumber[0].getValue() + ", длина = " + arrayNumber[0].getBitDepth());
            System.out.println("Самое короткое число: " + arrayNumber[arrayNumber.length - 1].getValue()
                    + ", длина = " + arrayNumber[arrayNumber.length - 1].getBitDepth());
        }
    }

    public Number[] getArrayNumberByString(String[] args) {
        Number[] arrayNumber = new Number[args.length];
        try {
            for (int i = 0; i < args.length; i++)
                arrayNumber[i] = new Number(Integer.parseInt(args[i]));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return arrayNumber;
    }

    public double getAvgLength() {
        double avg = 0;
        for (Number number : arrayNumber)
            avg += number.getBitDepth();
        return arrayNumber.length != 0 ? avg / arrayNumber.length : 0;

    }

    private void printFirstDifferentDigits() {
        for (Number number : arrayNumber) {
            if (number.isDifferentDigits()) {
                System.out.println("First number with different digits is " + number.getValue());
                return;
            }
        }
        System.out.println("Array does not contain number with different digits!");
    }

    private void printFirstGrowthDigits() {
        for (Number number : arrayNumber) {
            if (number.isGrowthOnly()) {
                System.out.println("First number with growth digits is " + number.getValue());
                return;
            }
        }
        System.out.println("Array does not contain number with growth digits!");
    }

    private void printCountOnlyEvenDigits() {
        int countEvenOnly = 0, countBalanceEvenAndOdd = 0;
        for (Number number : arrayNumber) {
            if (number.getEvenCount() == number.getBitDepth())
                countEvenOnly++;
            if (number.getEvenCount() == number.getOddCount())
                countBalanceEvenAndOdd++;
        }
        System.out.println("Количество чисел с только четными цифрами = " + countEvenOnly);
        System.out.println("Количество чисел с равным количеством четных и нечетных цифр = " + countBalanceEvenAndOdd);
    }

    private void printNumberWithSmallLength() {
        System.out.println("Числа с длиной, меньше средней");
        for (Number number : arrayNumber) {
            if (number.getBitDepth() < avgLength)
                System.out.println(number.getValue() + ", length = " + number.getBitDepth());
        }
    }

    private void printNumberWithBigLength() {
        System.out.println("Числа с длиной, больше средней");
        for (Number number : arrayNumber) {
            if (number.getBitDepth() > avgLength)
                System.out.println(number.getValue() + ", length = " + number.getBitDepth());
        }
    }


}
