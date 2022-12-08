package HWJava.HW4;

import java.util.LinkedList;

/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди, 
dequeue() - возвращает первый элемент из очереди и удаляет его, 
first() - возвращает первый элемент из очереди, не удаляя.

 */
public class HW4_Task2 {
    public static void main(String a[]) {
        LinkedList<Integer> queue = new LinkedList<>();
        enqueue(queue, 1);
        enqueue(queue, 2);
        enqueue(queue, 3);
        enqueue(queue, 4);
        enqueue(queue, 5);
        enqueue(queue, 6);
        System.out.println(queue);
        
        dequeue(queue);
        System.out.println(queue);
        
        first(queue);
        System.out.println(queue);

    }
    // enqueue() - помещает элемент в конец очереди
    static void enqueue(LinkedList<Integer> queue, int value) {
        queue.addLast(value);
    }

    // first() - возвращает первый элемент из очереди, не удаляя
    static void first(LinkedList<Integer> queue) {
        if (queue.size() == 0) {
            System.out.println("Очередь пуста");
        } else {
            int first = queue.getFirst();
            System.out.println("Первый элемент очереди - " + first);
        }

    }

    // dequeue() - возвращает первый элемент из очереди и удаляет его,
    static void dequeue(LinkedList<Integer> queue) {
        if (queue.size() == 0) {
            System.out.println("Очередь пуста");
        } else {
            int first = queue.getFirst();
            System.out.println("Первый элемент очереди - " + first);
            queue.removeFirst();
        }
    }
}
