package HWJava.HW3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
(Необязательная задача повышенной сложности)
    Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
        Разность:
        A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
        B - A = все числа из второй коллекции, которые не содержатся в первой
        Симметрическая разность:
        A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
 */
public class HW3_Task4 {
    public static void main(String[] args) {
        List<Integer> listA = listArray(10, 5, 20);
        List<Integer> listB = listArray(10, 5, 20);
        System.out.println("Коллекция А:\n" + listA);
        System.out.println("Коллекция В:\n" + listB);

        System.out.println("Разность А-В:\n" + collectionDifference(listA, listB));
        System.out.println("Разность В-А:\n" + collectionDifference(listB, listA));
        System.out.println("Симметрическая разность А^В:\n" + symmetricСollectionDifference(listA, listB));
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

    // вычисление разности коллекций
    static List<Integer> collectionDifference(List<Integer> listA, List<Integer> listB) {
        List<Integer> res = new ArrayList<>();
        for (Integer elementA : listA) {
            if (!listB.contains(elementA))
                res.add(elementA);
        }
        return res;
    }

    // вычисление симметричной разности коллекций
    static List<Integer> symmetricСollectionDifference(List<Integer> listA, List<Integer> listB) {
        List<Integer> res = new ArrayList<>();
        for (Integer elementA : collectionDifference(listA, listB)) {
            res.add(elementA);
        }
        for (Integer elementA : collectionDifference(listB, listA)) {
            res.add(elementA);
        }
        return res;
    }

}
