package ru.agmikhaylenko.optionalTask;

public class Number {

    private int value;
    private int[] digits;
    private int bitDepth;

    public Number(int number) {
        this.value = number;
        this.digits = getArrayDigits(number);
        this.bitDepth = digits.length;
    }

    public int getValue() {
        return value;
    }

    public int[] getDigits() {
        return digits;
    }

    public int getBitDepth() {
        return bitDepth;
    }

    public static int[] getArrayDigits(int number) {
        char[] characters = String.valueOf(Math.abs(number)).toCharArray();
        int[] digits = new int[characters.length];
        for (int i = 0; i < digits.length; i++)
            digits[i] = Integer.valueOf(String.valueOf(characters[i]));
        return digits;
    }

    public boolean isDifferentDigits() {
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j])
                    return false;
            }
        }
        return true;
    }

    public int getEvenCount() {
        int evenCount = 0;
        for (int digit : digits) {
            if (digit % 2 == 0)
                evenCount++;
        }
        return evenCount;
    }

    public int getOddCount() {
        return bitDepth - getEvenCount();
    }

    public boolean isGrowthOnly() {
        for (int i = 0; i < bitDepth - 1; i++) {
            if (digits[i] >= digits[i + 1])
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
