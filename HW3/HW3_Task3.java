package HWJava.HW3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.
 */
public class HW3_Task3 {
    public static void main(String[] args) {
        List<Integer> list = listArray(10, 1, 60);
        System.out.println(list);
        System.out.printf(
                "Минимальное значение списка - %d \nМаксимальное значение списка - %d \nСреднее арифметическое значение списка - %d \n ",
                minList(list), maxList(list), averageList(list));
    }

    // создание и рандомное заполнение листа
    static List<Integer> listArray(int size, int start, int end) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(start, end);
            list.add(num);
        }
        return list;
    }

    // минимальное значение в листе
    static int minList(List<Integer> list) {
        IntegerComparator ic = new IntegerComparator();
        list.sort(ic);
        int min = list.get(0);
        return min;
    }

    // максимальное значение в листе
    static int maxList(List<Integer> list) {
        IntegerComparator ic = new IntegerComparator();
        list.sort(ic);
        int max = list.get(list.size() - 1);
        return max;
    }

    // среднее арифметическое листа
    static int averageList(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            sum += element;
        }
        int average = sum / list.size();
        return average;
    }
}
