package HWJava.HW2;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */

public class HW2_Task2 {
    
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
    static void bubbleSorter(int[] array) throws SecurityException, IOException  {
        Logger logger = Logger.getLogger(HW2_Task2.class.getName());
        FileHandler fh = new FileHandler("HWJava/HW2/log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
       

        for (int i = array.length - 1; i >= 1; i--) {
            logger.log(Level.INFO, String.format("i=%d",  i));

            for (int j = 0; j < i; j++) {
                logger.log(Level.INFO, String.format("j=%d",  j));
                
                if (array[j] > array[j + 1]) {
                    logger.log(Level.INFO, String.format("array[j]=%d",  array[j]));
                    logger.log(Level.INFO, String.format("array[j+1]=%d",  array[j+1]));

                    int temp = array[j];
                    // logger.log(Level.INFO, String.format("temp=%d",  temp));

                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.log(Level.INFO, String.format("temp=%d",  temp));

                }
            }
        }
    }
}
