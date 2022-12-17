package HWJava.HW6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/*
1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
2. Создать множество ноутбуков.
3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, 
отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
    “Введите цифру, соответствующую необходимому критерию:
    1 - ОЗУ
    2 - Объем ЖД
    3 - Операционная система
    4 - Цвет …
4. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Honor",
                "MateBook B3-420",
                14,
                "Windows 10",
                "Intel Core i5 1135G7",
                8, 512, 90_297));
        laptops.add(new Laptop("Apple",
                "MacBook Pro 13 M2",
                13,
                "Mac OS",
                "Apple M2",
                8, 512, 128_016));
        laptops.add(new Laptop("Apple",
                "MacBook Air M1",
                13,
                "Mac OS",
                "Apple M1",
                16, 512, 189_992));
        laptops.add(new Laptop("Lenovo",
                "ThinkBook",
                13,
                "Windows 11",
                "Intel Core i7",
                16, 512, 116_205));
        laptops.add(new Laptop("Lenovo",
                "16ACH6",
                16,
                "Windows 11",
                "AMD Ryzen 5 5600H",
                16, 512, 105_537));
        laptops.add(new Laptop("Apple",
                "MacBook Pro 16",
                16,
                "Mac OS",
                "Apple M1 Pro",
                16, 1000, 286_703));
        // System.out.println(laptops);

        Set<Laptop> filter = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        resultFilter(laptops, getFilterParameters(), filter);
        System.out.println(filter);
    }

}
