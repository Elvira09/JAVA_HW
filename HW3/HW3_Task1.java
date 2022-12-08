package HWJava.HW3;

import java.util.Random;

/*
Реализовать алгоритм сортировки слиянием
 */
public class HW3_Task1 {
    public static void main(String[] args) throws Exception {
        int[] array = fillingArrayRandomNumbers(10, 1, 101);
        printArray(array);
        printArray(sortArray(array));
    }

    // заполнение массива рандомно в заданном диапозоне
    static int[] fillingArrayRandomNumbers(int length, int min, int max) {
        Random random = new Random();
        int[] array = new int[length];
        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(max - min) + min;
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

    // сортировка левой и правой части массива
    static int[] sortArray(int[] array) {

        if (array == null)
            return null;
        if (array.length < 2)
            return array; // возврат из рекурсивного вызова

        int[] arrayLeft = new int[array.length / 2];
        System.arraycopy(array, 0, arrayLeft, 0, array.length / 2);
        int[] arrayRight = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayRight, 0, array.length - array.length / 2);

        arrayLeft = sortArray(arrayLeft);
        arrayRight = sortArray(arrayRight);

        return mergeArray(arrayLeft, arrayRight);
    }

    // слияние отсортированных массивов
    static int[] mergeArray(int[] arrayLeft, int[] arrayRight) {
        int[] arrayResult = new int[arrayLeft.length + arrayRight.length];
        int i = 0, j = 0, k = 0;
        while (i < arrayLeft.length && j < arrayRight.length) {
            arrayResult[k++] = arrayLeft[i] < arrayRight[j] ? arrayLeft[i++] : arrayRight[j++];
        }
        if (i < arrayLeft.length) {
            System.arraycopy(arrayLeft, i, arrayResult, k, arrayLeft.length - i);
        } else {
            if (j < arrayRight.length) {
                System.arraycopy(arrayRight, j, arrayResult, k, arrayRight.length - j);
            }
        }
        return arrayResult;
    }
}
