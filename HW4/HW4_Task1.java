package HWJava.HW4;

import java.util.LinkedList;
import java.util.Random;

/*
Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

 */
public class HW4_Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = linkedListRandom(10,-101,101);
        System.out.println(linkedList);
        
        System.out.println(reversalLinkedListRandom(linkedList));
    }

    // создание и рандомное заполнение LinkedList
    static LinkedList<Integer> linkedListRandom(int size, int start, int end) {
        Random random = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(start, end);
            linkedList.add(num);

        }
        return linkedList;
    }

    // разворот LinkedList
    static LinkedList<Integer> reversalLinkedListRandom(LinkedList<Integer> linkedList){
        LinkedList<Integer> linkedListResult = new LinkedList<>();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedListResult.addFirst(linkedList.get(i));
        }
        return linkedListResult;
    }    
}
