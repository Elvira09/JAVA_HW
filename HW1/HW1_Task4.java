package HWJava.HW1;

import HWJava.libraryHW;

/*
Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, 
например 1? + ?5 = 69. Требуется восстановить выражение до верного равенства. 
Предложить хотя бы одно решение или сообщить, что его нет.
 */
public class HW1_Task4 {
    public static void main(String[] args) {
        String equation = libraryHW.scannerText();
        System.out.println(libraryHW.restoringExpression(equation));
    }

}
