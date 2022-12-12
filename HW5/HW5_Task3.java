package HWJava.HW5;

import java.util.Random;

/*
Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */
public class HW5_Task3 {
    public static void main(String[] args) {
        int [] array = fillingArrayRandomNumbers(10, -50, 50);
        printArray(array);
        heapSort(array);
        printArray(array);
    }

    // заполнение массива рандомно в заданном диапозоне
    static int[] fillingArrayRandomNumbers(int length, int min, int max) {
        Random random = new Random();
        int[] array = new int[length];
        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(max - min) + min;
        }
        return array;
    }

    //  вывод на консоль одномерного массива
    static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //  пирамидальная сортировка (HeapSort)
    static void heapSort (int [] array){

        int n = array.length;
        for (int i = n/2-1; i>=0; i--){         
            heapSift (array, n,i);              
        } 
        for (int i=n-1; i >= 0; i--){            
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSift (array, i, 0);               
        }
    }

    //  делаем из массива макс-кучу для пирамидальной сортировки (HeapSort)
    static void heapSift(int [] array, int size, int top){     
        int leftChild = 2*top +1;
        int rightChild = 2*top + 2;
        int max = top;                                             
        if (leftChild < size && array [leftChild] > array [max])    
            max = leftChild;                                       
        if (rightChild < size && array [rightChild] > array [max])  
            max = rightChild;                                      
        if (max != top){                                          
            int temp = array[max];                                 
            array[max] = array[top];
            array[top] = temp;
            heapSift(array, size, max);                            
        }
    }

    
}
