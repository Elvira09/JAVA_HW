package HWJava.HW5;

import java.util.Arrays;

/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

 */
public class HW5_Task4 {
    public static void main(String[] args) {
        int N = 8;
        String[][] mat = new String[N][N];
        for (int i = 0; i < N; i++) { // заполняем всю доску '–', чтоб не выскакивал null после установленного ферзя в первой строке
            Arrays.fill(mat[i], "-");
        }
        arrangeQueens(mat, 0);
    }

    // проверяем угрожают ли два ферзя друг другу
    private static boolean queenNear(String[][] mat, int row, int column) {
        for (int i = 0; i < row; i++) // проверяем по столбцу
        {
            if (mat[i][column] == "Q") {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) // проверяем по диагонали
        {
            if (mat[i][j] == "Q") {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j < mat.length; i--, j++) // проверяем по второй диагонали
        {
            if (mat[i][j] == "Q") {
                return false;
            }
        }
        return true;
    }

    // вывод на консоль одномерного массива
    static void printArray(String[] array) {
        for (String element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    // печать решения
    private static void printSolution(String[][] mat) {
        for (String[] Strings : mat) {
            printArray(Strings);
        }
        System.out.println();
    }

    // расставляем ферзей
    private static void arrangeQueens(String[][] mat, int row) {
        if (row == mat.length) {
            printSolution(mat); //выводим решение если все расставлено удачно
            return;
        }
        for (int i = 0; i < mat.length; i++) // помещаем ферзя на каждую клетку в текущем ряду
        {
            if (queenNear(mat, row, i)) { // если два ферзя не угрожают друг другу 
                mat[row][i] = "Q"; // ставим ферзя на текущую клетку

                arrangeQueens(mat, row + 1); // повторить для следующей строки
                mat[row][i] = "–"; // возвращаемся назад и удаляем ферзя с текущей клетки

            }
        }
    }

}
