package HWJava.HW5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, 
которая найдет и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности
 */
public class HW5_Task2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Иван", "Иван", "Семён", "Иван", "Пётр", "Пётр", "Семён", 
                                        "Семён", "Иван", "Пётр", "Иван", "Пётр", "Пётр", "Пётр", "Семён");
        Map<String, Integer> counter = new HashMap<>();
        for (String name : list) {
            int newValue = counter.getOrDefault(name, 0) + 1;
            counter.put(name, newValue);
        }
        System.out.println(counter);
    }
}

