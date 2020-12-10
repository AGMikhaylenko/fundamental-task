package ru.agmikhaylenko.optionalTask;

import java.util.Comparator;

public class BitDepthComparator implements Comparator<Number> {
    @Override
    public int compare(Number o1, Number o2) {
        return o1.getBitDepth() - o2.getBitDepth();
    }
}
