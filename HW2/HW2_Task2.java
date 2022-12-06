package HWJava.HW2;

import java.io.IOException;
import java.util.Random;

/*
 Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

public class HW2_Task2 {
    // !!! НЕ СМОГЛА РЕАЛИЗОВАТЬ вторую часть задачи - результат после каждой итерации запишите в лог-файл 
    
    public static void main(String[] args) throws SecurityException, IOException  {
        int[] array = arrayNumber(6);
        System.out.println("Сгенерированный массив: ");
        printArray(array);
        bubbleSorter(array);
        System.out.println("Отсортированный массив: ");
        printArray(array);
    }

    // генерация случайного числа в заданном диапазоне
    static int getRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max - min) + min;
        return number;
    }

    // заполнение массива размером number рандомно
    static int[] arrayNumber(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = getRandomNumber(4, 99);
        }
        return array;
    }

    // вывод на консоль одномерного массива
    static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // пузырьковая сортировка
    static void bubbleSorter(int[] array)  {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
