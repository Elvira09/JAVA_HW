package HWJava.HW6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Filter {

    // фильтр по производителю
    private Set<Laptop> getFilterManufacturer(Set<Laptop> laptops, Set<Laptop> filter) {
        System.out.println("Какой производитель интересует? ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        for (Laptop element : laptops) {
            if (element.getManufacturer().toLowerCase().contains(text.toLowerCase()))
                filter.add(element);
            else
                continue;

        }
        return filter;
    }

    // фильтр по модели
    private Set<Laptop> getFilterModel(Set<Laptop> laptops, Set<Laptop> filter) {
        System.out.println("Какая модель интересует? ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        for (Laptop element : laptops) {
            if (element.getModel().toLowerCase().contains(text.toLowerCase()))
                filter.add(element);
            else
                continue;

        }
        return filter;
    }

    // фильтр по диагонали
    private Set<Laptop> getFilterScreenDiagonal(Set<Laptop> laptops, Set<Laptop> filter) {
        System.out.println("Какая диагональ экрана интересует?");
        Scanner sc = new Scanner(System.in);
        float numFloat = sc.nextFloat();
        for (Laptop element : laptops) {
            if (element.getScreenDiagonal() <= numFloat)
                filter.add(element);
            else
                continue;

        }
        return filter;
    }

    // фильтр по операционной системе
    private Set<Laptop> getFilterOperatingSystem(Set<Laptop> laptops, Set<Laptop> filter) {
        System.out.println("Какая операционная система интересует? ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        for (Laptop element : laptops) {
            if (element.getOperatingSystem().toLowerCase().contains(text.toLowerCase()))
                filter.add(element);
            else
                continue;

        }
        return filter;
    }

    // фильтр по процессору
    private Set<Laptop> getFilterProcessor(Set<Laptop> laptops, Set<Laptop> filter) {
        System.out.println("Какой процессор интересует? ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        for (Laptop element : laptops) {
            if (element.getProcessor().toLowerCase().contains(text.toLowerCase()))
                filter.add(element);
            else
                continue;
        }
        return filter;
    }

    // фильтр по оперативной памяти
    private Set<Laptop> getFilterRandomAccessMemory(Set<Laptop> laptops, Set<Laptop> filter) {
        System.out.println("Какая оперативная память интересует?");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (Laptop element : laptops) {
            if (element.getRandomAccessMemory() <= num)
                filter.add(element);
            else
                continue;
        }
        return filter;
    }

    // фильтр по SSD
    private Set<Laptop> getFilterSsdCapacit(Set<Laptop> laptops, Set<Laptop> filter) {
        System.out.println("Какой объем SSD интересует?");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (Laptop element : laptops) {
            if (element.getSsdCapacity() <= num)
                filter.add(element);
            else
                continue;
        }
        return filter;
    }

    // фильтр по цене
    private Set<Laptop> getFilterPric(Set<Laptop> laptops, Set<Laptop> filter) {
        System.out.println("Какая стоимость интересует?");
        Scanner sc = new Scanner(System.in);
        float numFloat = sc.nextFloat();
        for (Laptop element : laptops) {
            if (element.getPrice() <= numFloat)
                filter.add(element);
            else
                continue;

        }
        return filter;
    }

    // результат фильтрации
    public Set<Laptop> resultFilter(Set<Laptop> laptops, List<Integer> parametr, Set<Laptop> filter) {
        int i = 0;
        Boolean str = Boolean.parseBoolean(condition(parametr));
        System.out.println(!str);
        while (i < parametr.size() && !str) {
                if (parametr.get(i) == 1)
                    getFilterManufacturer(laptops, filter);
                else if (parametr.get(i) == 2)
                    getFilterModel(laptops, filter);
                else if (parametr.get(i) == 3)
                    getFilterScreenDiagonal(laptops, filter);
                else if (parametr.get(i) == 4)
                    getFilterOperatingSystem(laptops, filter);
                else if (parametr.get(i) == 5)
                    getFilterProcessor(laptops, filter);
                else if (parametr.get(i) == 6)
                    getFilterRandomAccessMemory(laptops, filter);
                else if (parametr.get(i) == 7)
                    getFilterSsdCapacit(laptops, filter);
                else if (parametr.get(i) == 8)
                    getFilterPric(laptops, filter);
                    i++;
                }
        

            if(filter.size()==0)
                System.out.println("По выбранным характеристикам вариантов нет");
        return filter;
    }

    // получение от пользователя параметров фильтрации
    public List<Integer> getFilterParameters() {
        System.out.println("\nВыберите категории фильтрации. Для завершения выбора наберите '0'");
        System.out.println(
                "1 - Производитель \n2 - Модель \n3 - Диагональ экрана \n4 - Операционая система \n5 - Процессор \n6 - Оперативная память \n7 - Объем SSD накопителя \n8 - Цена");
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        list.add(num);

        while (num != 0) {
            num = sc.nextInt();
            list.add(num);
        }
        list.remove(list.size() - 1);
        // sc.close();
        return list;
    }

    // формирование строки условия
    private String condition(List<Integer> list) {
        List<Integer> choice = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            choice.add(list.get(i));
        }
        String str = choice.toString().replace(",", " && ")
                .replace("[", "").replace("]", "");
        return str;
    }

    }
       

        

