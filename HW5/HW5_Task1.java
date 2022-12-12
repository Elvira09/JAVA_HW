package HWJava.HW5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
 */
public class HW5_Task1 {
    
    public static void main(String[] args) throws IOException {
        String pathFile = "/Users/GB/JAVA/HWJava/HW5/phoneBookTask1.txt";
        createFile(pathFile);

        Map<Integer, Map<String, String>> data = new HashMap<>();
        Map<String, String> people = new HashMap<>();

        if (scannerText("Добавить контакт  Y / N ?").equalsIgnoreCase("Y")) {
            Integer key = getLineCountByReader(pathFile) + 1;
            String name = scannerData("Введите имя ", 1).toString();
            String surname = scannerData("Введите фамилию ", 1).toString();
            String phone = scannerData("Введите телефон ", 3).toString();

            people.put("name", name);
            people.put("surname", surname);
            people.put("phone", phone);
            // можно добавить дополнительно поля типа почты, адреса, комментарии и прочее

            data.put(key, people);

            writerFile(pathFile, data);
        } else if (scannerText("Найти контакт  Y / N ?").equalsIgnoreCase("Y")) {
            // if(fileReader(pathFile, scannerText("Кого ищем ? ")))
            // else System.out.println("Ничего не");
            
            fileReader(pathFile, scannerText("Кого ищем ? "));
            
        } else
                System.out.println("Некорректный ввод  или еще раз подтвердите свои действи");

    }

    // считывание текста из консоли
    static String scannerText(String messag) {
        Scanner sc = new Scanner(System.in);
        System.out.println(messag);
        String text = sc.nextLine();
        // sc.close();
        return text;
    }

    // проверка наличия файла и создание при необходимости
    static void createFile(String pathFile) {
        try {
            File file = new File(pathFile);
            if (file.createNewFile())
                System.out.println("Файл создан");
            else
                System.out.println("Файл уже существует");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // запись/дозапись в файл
    static String writerFile(String pathFile, Map<Integer, Map<String, String>> data) {
        try (FileWriter fw = new FileWriter(pathFile, true)) // true - данные дозаписываются в конец файла, а при false
        // - файл полностью перезаписывается
        {
            fw.write(data.toString());
            fw.append("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return data.toString();
    }

    // чтение файла и поиск вхождения в содержание
    static String fileReader(String pathFile, String find) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathFile));
        String line = br.readLine();
        while (line != null) {
            if (line.toLowerCase().contains(find))
                System.out.println(line);
            else System.out.println("Ничего не найдено "); 
            /*
            не могу сообразить как сделать, чтоб сообщение выводилось один раз и не выводилось при результативном поиске
                Найти контакт  Y / N ?
                y
                Кого ищем ? 
                dsfghjkhl;
                Ничего не найдено 
                Ничего не найдено 
                Ничего не найдено 
                Ничего не найдено
            и не выводилось при результативном поиске вместо считанных строк
                Найти контакт  Y / N ?
                y
                Кого ищем ? 
                ирина
                Ничего не найдено 
                Ничего не найдено 
                Ничего не найдено 
                {4={phone=[89217328505, 89007891278, ], surname=[Казанцева], name=[Ирина]}}
             */
            line = br.readLine();
            
        }
       
        br.close();
        return line;
    }

    // подсчет строк в файле 
    static Integer getLineCountByReader(String pathFile) throws IOException {
        try (var lnr = new LineNumberReader(new BufferedReader(new FileReader(pathFile)))) {
            while (lnr.readLine() != null)
                ;
            return lnr.getLineNumber();
        }
    }

    // считывание данных из консоли
    static ArrayList<String> scannerData(String messag, int num) {
        System.out.println(messag);
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<String>(num);
        while (arrayList.size() < num) {
            arrayList.add(sc.nextLine());
        }
        // sc.close();
        return arrayList;
    }

}
