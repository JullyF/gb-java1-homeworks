package Java1Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] map;
    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final String AI_WIN_MSG = "Победил компьютер!";
    private static final String HUMAN_WIN_MSG = "Вы победили!";
    private static final String DRAW_MSG = "Ничья!";

    private static Scanner scanner;
    private static Random rand;


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        rand = new Random();

        initMap();
        printMap();
        startGameLoop();
    }

    private static void startGameLoop() {
        // запускаем непосредственно цикл игры, который работает до победы
        while (true) {
            humanTurn();
            printMap();
            if (checkEndGame(DOT_X)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEndGame(DOT_O)) {
                break;
            }
        }
    }


    public static void initMap() {
        //создаём карту и заполняем её символами, обозначающими свободную ячейку
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        // создаём отдельный метод для печати карты, т.к. к нему придётся возращаться несколько раз
        // 1) печатаем шапочку
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        // 2) печатаем порядковый номер строк
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "  ");

            // 3) печатаем состояние игрового поля
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }

        //разделяем вывод карты между ходами
        System.out.println();
        System.out.println("  -- *** --  \n");

    }

    public static void humanTurn() {
        int row = 0;
        int col = 0;

        // Когда вводишь неверное значение, а потом сразу верное, первый раз он его не принимает,
        // а снова просит нужный диапазон координат. И присваивает последнюю цифру предфдущего ввода + первую
        // следующего ввода. Исправили вторым Scanner.Next() в метод readIndex.
        // Не уверена, что это верное решение, но другого пока не вижу.

        do {
            System.out.println("Введите координаты в формате X Y (где Х - номер строки, Y - номер столбца): ");
            row = readIndex();
            col = readIndex();

            if (!checkRange(row) || !checkRange(col)) {
                System.out.printf("Координаты должны быть в диапазоне от 1 до %d.%n", SIZE);
                continue;
            }
            if (isEmptyCell(row - 1, col - 1)) {
                break;
            } else {
                System.out.println("Ячейка уже занята!");
            }

        } while (true);
        map[row - 1][col - 1] = DOT_X; // присваиваем символ хода пользователя в соответствующий
        // элемент массива с нашим полем (картой)
    }

    private static int readIndex() {
        // проверяем на ввод именно целых чисел
        while (!scanner.hasNextInt()) {
            System.out.println("Координаты должны иметь целочисленное значение! Введите координаты снова: ");
            scanner.next();
            scanner.next();
        }
        return scanner.nextInt();
    }

    // проверяем, что введённые координаты находятся в пределах карты
    private static boolean checkRange(int index) {
        return index >= 1 && index <= SIZE;
    }

    private static void aiTurn() {
        int raw, col;
        do {
            // используем do while, чтобы прошла хотя бы одна итерация цикла
            // с помощью метода rand.nextInt(SIZE) возвращаем случайное число от 0 до (SIZE - 1)
            raw = rand.nextInt(SIZE);
            col = rand.nextInt(SIZE);
        } while (!isCellValid(raw, col)); // проверяем, свободна ли клетка
        System.out.println("Компьютер сделал ход в ячейку " + (raw + 1) + " " + (col + 1));
        map[raw][col] = DOT_O; // присваиваем символ хода компьютера в соответствующий элемент массива с нашим полем (картой)
    }

    public static boolean isCellValid(int row, int col) {
        // проверяем валидность координат
        if (col < 0 || col >= SIZE || row < 0 || row >= SIZE) return false;
        // проверяем, свободна ли ячейка для хода
        if (map[row][col] == DOT_EMPTY) return true;
        return false;
    }

    private static boolean checkWinRowsAndColumns(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int rowCounter = 0; // сбрасываем счётчик на каждой итерации цикла, иначе он прибавит к двум предыдущим символам первый следующий
            int colCounter = 0; // сбрасываем счётчик на каждой итерации цикла, иначе он прибавит к двум предыдущим символам первый следующий
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    rowCounter = rowCounter + 1;
                } else { // else не нужен при условии, когда размер поля равен размеру выигрышной комбинации. Иначе нужен сброс счётчика
                    rowCounter = 0;
                }
                if (map[j][i] == symb) {
                    colCounter = colCounter + 1;
                } else { // else не нужен при условии, когда размер поля равен размеру выигрышной комбинации. Иначе нужен сброс счётчика
                    colCounter = 0;
                }
                if (rowCounter == DOTS_TO_WIN || colCounter == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinDiagonals(char symb) {
        int diag1Counter = 0;
        int diag2Counter = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                diag1Counter = diag1Counter + 1;
            } else {
                diag1Counter = 0;
            }

            if (map[i][SIZE - 1 - i] == symb) {
                diag2Counter = diag2Counter + 1;
            } else {
                diag2Counter = 0;
            }
            if (diag1Counter == DOTS_TO_WIN || diag2Counter == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }


    private static boolean checkWin(char symb) {
        return checkWinRowsAndColumns(symb) || checkWinDiagonals(symb);
    }

    private static boolean isMapFull() {
        // проверяем, заполнена ли наша карта
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // проверяет наличие свободных клеток в каждом столбце для каждой строки
                if (isEmptyCell(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    // проверяем, свободна ли клетка; если там соответствующий символ - возвращает true
    private static boolean isEmptyCell(int row, int col) {
        return map[row][col] == DOT_EMPTY;
    }

    // проверяем, закончена ли игра
    private static boolean checkEndGame(char symbol) {
        // печатаем выражение о выигрыше либо компьютера, либо человека.
        if (checkWin(symbol)) {
            System.out.println(getWinMessageBy(symbol));
            return true;
        }

        // если карта полная, но выигрыша нет, то печатаем сообщение о ничье.
        // Этот код нельзя ставить первым, т.к. при выигрыше на последнем ходе, он печатает ничью. ???
        if (isMapFull()) {
            System.out.println(DRAW_MSG);
            return true;
        }
        return false;
    }

    private static String getWinMessageBy(char symbol) {
//
//        if (symbol == DOT_X) {
//            return HUMAN_WIN_MSG;
//        } else {
//            return AI_WIN_MSG;
//        }
// то же самое
        return symbol == DOT_X ? HUMAN_WIN_MSG : AI_WIN_MSG;
    }


}
