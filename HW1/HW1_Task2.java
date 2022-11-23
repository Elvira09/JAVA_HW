package HWJava.HW1;

/*
Вывести все простые числа от 1 до 1000
 */
public class HW1_Task2 {
    public static void main(String[] args) {
        int divider  = 0; 
        for (int i = 1; i <=1000; i++) {
            for (int j = 1; j <= i; j++) { 
                if (i % j == 0)
                divider++; 
            }
            if (divider == 2) System.out.println(i);
            else divider = 0; 
        }
    }
}
