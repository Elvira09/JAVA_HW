package HWJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import HWJava.HW3.IntegerComparator;

public class libraryHW {
    // генерация случайного числа в заданном диапазоне
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt(max - min) + min;
        return number;
    }

    // вычисление треугольного числа
    public static int triangularNumber(int number) {
        int result = (number * (number + 1)) / 2;
        return result;
    }

    // факториал
    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    // считывание числа с консоли
    public static double getNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        double num;
        if (sc.hasNextDouble())
            num = sc.nextDouble();
        else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            sc.next();
            num = getNumber();
        }
        // sc.close(); // при закрытии сканера выдает ошибку при считывании следующей
        // позиции
        return num;
    }

    // запрос операции с консоли для калькулятора
    public static char getOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите операцию:");
        char operation;
        if (sc.hasNext())
            operation = sc.next().charAt(0);
        else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            sc.next();
            operation = getOperation();
        }
        sc.close();
        return operation;
    }

    // простой калькулятор
    public static double calc(double num1, double num2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }

    // считывание текста из консоли
    static String scannerText(String messag) {
        Scanner sc = new Scanner(System.in);
        System.out.println(messag);
        String text = sc.nextLine();
        // sc.close();
        return text;
    }

    // поиск элемента в строковом массиве
    public static String findingArrayElement(String[] text, String elementToSearch) {
        for (int i = 0; i < text.length; i++) {
            if (text[i].equals(elementToSearch)) {
                return text[i];
            }
        }
        return elementToSearch;
    }

    // проверка выражения
    public static boolean checkExpression(String x, String y, String res) {
        int first = Integer.parseInt(x);
        int second = Integer.parseInt(y);
        int sum = Integer.parseInt(res);
        if (first + second == sum) {
            return true;
        } else {
            return false;
        }
    }

    // Mетод восстанавливающий выражение из формы 1? + ?5 = 69
    public static String restoringExpression(String expression) {
        String[] arrayExpression = expression.split(" ");
        String first = arrayExpression[0];
        String second = arrayExpression[2];
        String sum = arrayExpression[4];
        String x = "";
        String y = "";
        String result = "";
        for (int i = 0; i < 10; i++) {
            x = first.replace("?", Integer.toString(i));
            for (int j = 0; j < 10; j++) {
                y = second.replace("?", Integer.toString(j));
                if (checkExpression(x, y, sum) == true) {
                    return result + x + " + " + y + " = " + sum;
                }
                y = "";
            }
            x = "";
        }
        return "Решения не существует!";
    }

    // чтение файла
    static String fileReader(String file) throws IOException {
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

    // заполнение массива размером number рандомно
    static int[] arrayNumber(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomNumber(min, max);
        }
        return array;
    }

    // вывод на консоль одномерного массива
    static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // пузырьковая сортировка с логированием итераций
    static void bubbleSorter(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // преобразование строки с данными в билдер
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

    // заполнение массива рандомно в заданном диапозоне
    static int[] fillingArrayRandomNumbers(int length, int min, int max) {
        Random random = new Random();
        int[] array = new int[length];
        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(max - min) + min;
        }
        return array;
    }

    // сортировка левой и правой части массива
    static int[] sortArray(int[] array) {

        if (array == null)
            return null;
        if (array.length < 2)
            return array; // возврат из рекурсивного вызова

        int[] arrayLeft = new int[array.length / 2];
        System.arraycopy(array, 0, arrayLeft, 0, array.length / 2);
        int[] arrayRight = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayRight, 0, array.length - array.length / 2);

        arrayLeft = sortArray(arrayLeft);
        arrayRight = sortArray(arrayRight);

        return mergeArray(arrayLeft, arrayRight);
    }

    // слияние отсортированных массивов
    static int[] mergeArray(int[] arrayLeft, int[] arrayRight) {
        int[] arrayResult = new int[arrayLeft.length + arrayRight.length];
        int i = 0, j = 0, k = 0;
        while (i < arrayLeft.length && j < arrayRight.length) {
            arrayResult[k++] = arrayLeft[i] < arrayRight[j] ? arrayLeft[i++] : arrayRight[j++];
        }
        if (i < arrayLeft.length) {
            System.arraycopy(arrayLeft, i, arrayResult, k, arrayLeft.length - i);
        } else {
            if (j < arrayRight.length) {
                System.arraycopy(arrayRight, j, arrayResult, k, arrayRight.length - j);
            }
        }
        return arrayResult;
    }

    // создание и рандомное заполнение листа
    public static List<Integer> listArray(int size, int start, int end) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(start, end);
            list.add(num);
        }
        return list;
    }

    // удаление эле ментов с четным значением из листа
    public static List<Integer> removingEvenElements(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(list.get(i));
                i--;
            }
        }
        return list;
    }

    // минимальное значение в листе
    public static int minList(List<Integer> list) {
        IntegerComparator ic = new IntegerComparator();
        list.sort(ic);
        int min = list.get(0);
        return min;
    }

    // максимальное значение в листе
    public static int maxList(List<Integer> list) {
        IntegerComparator ic = new IntegerComparator();
        list.sort(ic);
        int max = list.get(list.size() - 1);
        return max;
    }

    // среднее арифметическое листа
    public static int averageList(List<Integer> list) {
        int sum = 0;
        for (Integer element : list) {
            sum += element;
        }
        int average = sum / list.size();
        return average;
    }

    // вычисление разности коллекций
    public static List<Integer> collectionDifference(List<Integer> listA, List<Integer> listB) {
        List<Integer> res = new ArrayList<>();
        for (Integer elementA : listA) {
            if (!listB.contains(elementA))
                res.add(elementA);
        }
        return res;
    }

    // вычисление симметричной разности коллекций
    public static List<Integer> symmetricСollectionDifference(List<Integer> listA, List<Integer> listB) {
        List<Integer> res = new ArrayList<>();
        for (Integer elementA : collectionDifference(listA, listB)) {
            res.add(elementA);
        }
        for (Integer elementA : collectionDifference(listB, listA)) {
            res.add(elementA);
        }
        return res;
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
    static LinkedList<Integer> reversalLinkedListRandom(LinkedList<Integer> linkedList) {
        LinkedList<Integer> linkedListResult = new LinkedList<>();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedListResult.addFirst(linkedList.get(i));
        }
        return linkedListResult;
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

    // постфиксный калькулятор
    static Object calculatePostFix(String postFix) {
        String[] postFixArray = postFix.split(" ");
        Deque<Double> deque = new ArrayDeque<>();
        for (int i = 0; i < postFixArray.length; i++) {
            String elem = postFixArray[i];
            if (isNumber(elem)) {
                deque.push(Double.parseDouble(elem));
            } else if (elem.equals("+") && deque.size() >= 2) {
                double res = deque.pop() + deque.pop();
                deque.push(res);
            } else if (elem.equals("*") && deque.size() >= 2) {
                double res = deque.pop() * deque.pop();
                deque.push(res);
            } else if (elem.equals("^") && deque.size() >= 2) {
                double secondOp = deque.pop();
                double res = Math.pow(deque.pop(), secondOp);
                deque.push(res);
            } else if (elem.equals("-") && deque.size() >= 2) {
                double secondOp = deque.pop();
                double res = deque.pop() - secondOp;
                deque.push(res);
            } else if (elem.equals("/") && deque.size() >= 2) {
                double secondOp = deque.pop();
                double res = deque.pop() / secondOp;
                deque.push(res);
            }
        }
        if (!isSteck(deque)) {
            System.out.println("Выражение введено некорректно");
        } else
            return deque.pop();
        return null;
    }

    // проверка является ли строка числом
    static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // проверяем стек на наличие всего лишь одного элемента (результата вычислений)
    static boolean isSteck(Deque<Double> deque) {
        if (deque.size() == 1)
            return true;
        return false;
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
            if (line.contains(find))
                System.out.println(line);
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

    // пирамидальная сортировка (HeapSort)
    static void heapSort(int[] array) {

        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapSift(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSift(array, i, 0);
        }
    }

    //  делаем из массива макс-кучу для пирамидальной сортировки (HeapSort)
    static void heapSift(int[] array, int size, int root) {
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        int max = root;
        if (leftChild < size && array[leftChild] > array[max])
            max = leftChild;
        if (rightChild < size && array[rightChild] > array[max])
            max = rightChild;
        if (max != root) {
            int temp = array[max];
            array[max] = array[root];
            array[root] = temp;
            heapSift(array, size, max);
        }
    }
}
