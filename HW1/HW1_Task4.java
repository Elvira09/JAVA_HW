package HWJava.HW1;

import java.util.Scanner;

import HWJava.libraryHW;

/*
Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, 
например 1? + ?5 = 69. Требуется восстановить выражение до верного равенства. 
Предложить хотя бы одно решение или сообщить, что его нет.
 */
public class HW1_Task4 {
    public static void main(String[] args) {
        String equation = scannerText("Введите выражение для восстановления ");
        System.out.println(restoringExpression(equation));
    }

    // считывание текста из консоли
    static String scannerText(String messag) {
        Scanner sc = new Scanner(System.in);
        System.out.println(messag);
        String text = sc.nextLine();
        sc.close();
        return text;
    }

    /// проверка выражения
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

    // восстановление выражения из формы 1? + ?5 = 69
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


}
