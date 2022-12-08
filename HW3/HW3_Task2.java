package HWJava.HW3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
 */
public class HW3_Task2 {
    public static void main(String[] args) {
        List<Integer> list = listArray(10, 1, 101);
        System.out.println(list);
        System.out.println(removingEvenElements(list));
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

    // удаление эле ментов с четным значением из листа
    public static List<Integer> removingEvenElements(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(list.get(i));
                i--;
            }
        }
        return list;
    }
}
