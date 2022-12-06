package HWJava.HW2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Дана строка json:
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, 
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод, который распарсит json и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет]. Например:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

 */
public class HW2_Task3 {

    public static void main(String[] args) throws IOException {
        String path = "HWJava/HW2/HW2_Task3.txt";

        String data = fileReader(path).replace(" ", "")
                .replace("[", "")
                .replace("]", "")
                .replace("{", "")
                .replace("}", "")
                .replace("\"", " ");

        getStudentInfo(data);

    }

    // чтение файла
    static String fileReader(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = br.readLine();
        System.out.println();
        br.close();
        return str;
    }

    // преобразование строки с данными  в билдер
    static StringBuilder getStudentInfo(String data) {
        StringBuilder builder = new StringBuilder();
        String[] startStudent = data.split(", ");
        for (String elem : startStudent) {
            String[] resultStudent = elem.split(": ");
            String value = resultStudent[1];
            builder.append(value);
        }
        StringBuilder resBuilder = new StringBuilder();
        String[] str = builder.toString().split(" ");
        for (int i = 0; i < str.length; i += 3) {
            resBuilder.append(String.format("Студент %s получил %s по предмету %s \n", str[i], str[i + 1], str[i + 2]));

        }
        System.out.println(resBuilder);
        return resBuilder;
    }
}
