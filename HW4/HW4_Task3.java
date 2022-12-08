package HWJava.HW4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
*Напишите постфиксный калькулятор. Пользователь вводит данные и операции в обратной польской записи. 
Калькулятор вычисляет результат и проверяет, что в стэке получилось единственное число.

    Например:
    5 4 3 - + => 5 1 + => 6
 */
public class HW4_Task3 {
    public static void main(String[] args) {
        System.out.println(calculatePostFix(scannerText()));
    }

    // считывание текста из консоли
    static String scannerText() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение в постфиксной форме ");
        String text = sc.nextLine();
        sc.close();
        return text;
    }

    // постфиксный калькулятор
    static Object calculatePostFix(String postFix) {
        String[] postFixArray = postFix.split(" ");
        Deque<Double> deque = new ArrayDeque<>();
        for (int i = 0; i < postFixArray.length; i++) {
            String elem = postFixArray[i];
            if (isNumber(elem)) { 
                deque.push(Double.parseDouble(elem));
            } else if (elem.equals("+") && deque.size() >= 2) {
                double res = deque.pop() + deque.pop();
                deque.push(res);
            } else if (elem.equals("*") && deque.size() >= 2) {
                double res = deque.pop() * deque.pop();
                deque.push(res);
            } else if (elem.equals("^") && deque.size() >= 2) {
                double secondOp = deque.pop();
                double res = Math.pow(deque.pop(), secondOp);
                deque.push(res);
            } else if (elem.equals("-") && deque.size() >= 2) {
                double secondOp = deque.pop();
                double res = deque.pop() - secondOp;
                deque.push(res);
            } else if (elem.equals("/") && deque.size() >= 2) {
                double secondOp = deque.pop();
                double res = deque.pop() / secondOp;
                deque.push(res);
            }
        }
        if (!isSteck(deque)) {
            System.out.println("Выражение введено некорректно");
        }else return deque.pop();
        return null;
    }

    // проверка является ли строка числом
    static boolean isNumber(String str) { 
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // проверяем стек на наличие всего лишь одного элемента (результата вычислений)
    static boolean isSteck(Deque<Double> deque) {
        if (deque.size() == 1)
            return true;
        return false;
    }
}
