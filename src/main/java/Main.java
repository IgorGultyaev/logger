import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int getRandom(int intRange) {
        return (int) (Math.random() * intRange);
    }

    private static List<Integer> listOfInteger(int size, int limit) {
        List<Integer> listCreate = new ArrayList<>();
        System.out.print("Вот случайный список:");
        for (int numOfList = 0; numOfList < size; numOfList++) {
            listCreate.add(getRandom(limit));
        }
        return listCreate;
    }

    private static boolean strIsNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            Logger.getInstance().log("Введённое значение не является числом");
            return false;
        }
    }

    private static int input(Scanner scanner, String msg){
        String sizeLN;
        do {
            System.out.print(msg);
            sizeLN = scanner.nextLine();
        } while (!strIsNum(sizeLN));
        return Integer.parseInt(sizeLN);
    }

    public static void main(String[] args) {
        List<Integer> list;
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        Scanner scanner = new Scanner(System.in);

        int size = input(scanner, "Введите размер списка: ");
        int limit = input(scanner,"Введите верхнюю границу для значений: ");
        list = listOfInteger(size,limit);
        System.out.println("Вот случайный список:" + list);
        int filtering = input(scanner,"Введите порог для фильтра: ");
        Filter filter = new Filter(filtering);
        list = filter.filterOut(list);
        logger.log("Отфильтрованный список:" + list);
        logger.log("Завершаем программу");

        scanner.close();

    }
}