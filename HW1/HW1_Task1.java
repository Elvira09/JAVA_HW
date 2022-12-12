package HWJava.HW1;

import java.util.Random;


/*
Вычислить n-ое треугольного число(сумма чисел от 1 до n), 
n! (произведение чисел от 1 до n)

    // 0, 1, 2, 3, 4,  5,   6,   7,    8,     9,      10... ЧИСЛО
    // 0, 1, 3, 6, 10, 15,  21,  28,   36,    45,     55 ...ТРЕУГОЛЬТНОЕ ЧИСЛО Tn = (n*(n+1))/2
    // 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800...ФАКТОРИАЛ
 */
public class HW1_Task1 {
    public static void main(String[] args) {
        int number = getRandomNumber(1, 10);

        System.out.println("Рандомное число - " + number);
        System.out.println("Треугольное число - " + triangularNumber(number));
        System.out.println("Факториал числа  - " + factorial(number));
    }

    // генерация случайного числа в заданном диапазоне
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max - min) + min;
        return number;
    }

    // вычисление треугольного числа
    public static int triangularNumber(int number) {
        int result = (number * (number + 1)) / 2;
        return result;
    }

    // факториал
    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

}
