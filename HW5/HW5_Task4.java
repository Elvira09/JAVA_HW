package HWJava.HW5;

import java.util.Arrays;

/*
На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

 */
public class HW5_Task4 {
    public static void main(String[] args)
    {
        int N = 8;
        char[][] mat = new char[N][N];
         for (int i = 0; i < N; i++) { //заполняем всю доску '–'
            Arrays.fill(mat[i], '–');
        }
        nQueen(mat, 0);
    }
        
    // проверяем угрожают ли два ферзя друг другу 
    private static boolean isSafe(char[][] mat, int row, int column)
    {
        for (int i = 0; i < row; i++)  // проверяем по столбцу
        {
            if (mat[i][column] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) // проверяем по диагонали
        {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j < mat.length; i--, j++)  // проверяем по  второй диагонали
        {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
 
    // печать решения
    private static void printSolution(char[][] mat)
    {
        for (char[] chars: mat) {
            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
        }
        System.out.println();
    }
 
    private static void nQueen(char[][] mat, int row)
    {
        if (row == mat.length)
        {
            printSolution(mat);
            return;
        }
        for (int i = 0; i < mat.length; i++)        // помещаем ферзя на каждую клетку в текущем ряду
        {
            if (isSafe(mat, row, i))
            {               
                mat[row][i] = 'Q';      // ставим ферзя на текущую клетку               
                nQueen(mat, row + 1);   // повторить для следующей строки              
                mat[row][i] = '–';  // возвращаемся назад и удаляем ферзя с текущей клетки
            }
        }
    }
    
}
