package HWJava.HW1;

import java.util.Scanner;

/*
 Реализовать простой калькулятор
 */
public class HW1_Task3 {
    public static void main(String[] args) {
        double num1 = getNumber();
        double num2 = getNumber();
        char operation = getOperation();

        System.out.println(num1 + " " + operation + " " + num2 + " = " + calc(num1, num2, operation));
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

}
