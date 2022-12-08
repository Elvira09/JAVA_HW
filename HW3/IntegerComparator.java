package HWJava.HW3;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2; //o1-o2 - возрастание , 02-01  - убывание
    }
}