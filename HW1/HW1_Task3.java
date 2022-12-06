package HWJava.HW1;

import HWJava.libraryHW;

/*
 Реализовать простой калькулятор
 */
public class HW1_Task3 {
    public static void main(String[] args) {
        double num1 = libraryHW.getNumber();
        double num2 = libraryHW.getNumber();
        char operation = libraryHW.getOperation();

        System.out.println(num1 + " " + operation + " " + num2 + " = " + libraryHW.calc(num1, num2, operation));
    }
    
}
