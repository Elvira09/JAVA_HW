package HWJava.HW2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
В файле содержится строка с исходными данными в такой форме: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.
 */
public class HW2_Task1 {
    public static void main(String[] args) throws IOException {
        String path = "HWJava/HW2/HW2_Task1.txt";
        String data = fileReader(path).replace("\"", " ");

        // System.out.println("Считанные данные из файла:\n" + data);
        System.out.println("SELECT * FROM students WHERE " + getStudent(data).substring(0, getStudent(data).length() - 4));

    }

    //    чтение файла 
    static String fileReader (String file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = br.readLine();
        System.out.println();
        br.close();
        return str;
    }

    // преобразование строки с данными студента в билдер
    static StringBuilder getStudent(String data) {
        StringBuilder builder = new StringBuilder();

        String[] startStudent = data.split(", ");
        for (String elem : startStudent) {
            String[] resultStudent = elem.split(": ");
            String key = resultStudent[0];
            String value = resultStudent[1];

            if (!value.equals("null "))
                builder.append(String.format("%s= \"%s\" AND ", key, value));
        }
        return builder;
    }
}