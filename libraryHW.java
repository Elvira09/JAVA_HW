package HWJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class libraryHW {
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

    // считывание числа с консоли
    public static double getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        double num;
        if (sc.hasNextDouble())
            num = sc.nextDouble();
        else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            sc.next();
            num = getNumber();
        }
        // sc.close(); // при закрытии сканера выдает ошибку при считывании следующей
        // позиции
        return num;
    }

    // запрос операции с консоли для калькулятора
    public static char getOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите операцию:");
        char operation;
        if (sc.hasNext())
            operation = sc.next().charAt(0);
        else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            sc.next();
            operation = getOperation();
        }
        sc.close();
        return operation;
    }

    // простой калькулятор
    public static double calc(double num1, double num2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }

    // считывание текста из консоли
    public static String scannerText() {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        sc.close();
        return text;
    }

    // поиск элемента в строковом массиве
    public static String findingArrayElement(String[] text, String elementToSearch) {
        for (int i = 0; i < text.length; i++) {
            if (text[i].equals(elementToSearch)) {
                return text[i];
            }
        }
        return elementToSearch;
    }

    // проверка выражения
    public static boolean checkExpression(String x, String y, String res) {
        int first = Integer.parseInt(x);
        int second = Integer.parseInt(y);
        int sum = Integer.parseInt(res);
        if (first + second == sum) {
            return true;
        } else {
            return false;
        }
    }

    // Mетод восстанавливающий выражение из формы 1? + ?5 = 69
    public static String restoringExpression(String expression) {
        String[] arrayExpression = expression.split(" ");
        String first = arrayExpression[0];
        String second = arrayExpression[2];
        String sum = arrayExpression[4];
        String x = "";
        String y = "";
        String result = "";
        for (int i = 0; i < 10; i++) {
            x = first.replace("?", Integer.toString(i));
            for (int j = 0; j < 10; j++) {
                y = second.replace("?", Integer.toString(j));
                if (checkExpression(x, y, sum) == true) {
                    return result + x + " + " + y + " = " + sum;
                }
                y = "";
            }
            x = "";
        }
        return "Решения не существует!";
    }

    // чтение файла
    static String fileReader(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = br.readLine();
        System.out.println();
        br.close();
        return str;
    }

    // преобразование строки с данными студента в билдер
    static StringBuilder getStudent(String data) {
        StringBuilder builder = new StringBuilder();

        String[] startStudent = data.split(", ");
        for (String elem : startStudent) {
            String[] resultStudent = elem.split(": ");
            String key = resultStudent[0];
            String value = resultStudent[1];

            if (!value.equals("null "))
                builder.append(String.format("%s= \"%s\" AND ", key, value));
        }
        return builder;
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
    static void bubbleSorter(int[] array) {
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

    // преобразование строки с данными в билдер
    static StringBuilder getStudentInfo(String data) {
        StringBuilder builder = new StringBuilder();
        String[] startStudent = data.split(", ");
        for (String elem : startStudent) {
            String[] resultStudent = elem.split(": ");
            String value = resultStudent[1];
            builder.append(value);
        }
        StringBuilder resBuilder = new StringBuilder();
        String[] str = builder.toString().split(" ");
        for (int i = 0; i < str.length; i += 3) {
            resBuilder.append(String.format("Студент %s получил %s по предмету %s \n", str[i], str[i + 1], str[i + 2]));

        }
        System.out.println(resBuilder);
        return resBuilder;
    }

}
