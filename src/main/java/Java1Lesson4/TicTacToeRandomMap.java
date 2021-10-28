package Java1Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeRandomMap {
    private static char[][] map;
    private static final int DOTS_TO_WIN = 4;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final String AI_WIN_MSG = "ВЫ ПРОИГРАЛИ!";
    private static final String HUMAN_WIN_MSG = "ВЫ ПОБЕДИЛИ!";
    private static final String DRAW_MSG = "НИЧЬЯ!";

    private static Scanner scanner;
    private static Random rand;
    private static int size;

    // При выполнении этого задания подглядывала в подсказки. Для меня это сложно, но считаю, что лучше разобраться
    // при помощи подсказок, чем не сделать вообще.

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        rand = new Random();
        size = inputSizeMap();

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


    public static int inputSizeMap() {
        // Вводим размер карты. Ограничиваю от 4, т.к. выигрышная комбинация по заданию - 4,
        // а до 9 - потому что с двузначными числами поле некрасивое
        int sizeMap;

        do {

            System.out.println("Введите число для обозначения размера стороны квадратного игрового поля (количество ячеек) от 4 до 9: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Размер нужно задать целым числом! Попробуйте снова: ");
                scanner.next();
            }
            sizeMap = scanner.nextInt();
            if (sizeMap < 4 || sizeMap > 9) {
                System.out.println("Размер нужно задать целым числом в диапазоне от 4 до 9! ");
                continue;
            } else {
                break;
            }

        } while (true);


        return sizeMap;
    }


    public static void initMap() {
        //создаём карту и заполняем её символами, обозначающими свободную ячейку
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        // Создаём отдельный метод для печати карты, т.к. к нему придётся возвращаться несколько раз
        // 1) печатаем шапочку
        for (int i = 0; i <= size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        // 2) печатаем порядковый номер строк
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + "  ");

            // 3) печатаем состояние игрового поля
            for (int j = 0; j < size; j++) {
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
                System.out.printf("Координаты должны быть в диапазоне от 1 до %d.%n", size);
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
        return index >= 1 && index <= size;
    }

    private static void aiTurn() {
        // сначала проверяем, будет следующий ход компьютера выигрышным, если да - ход в эти координаты
        int[] cell = getNextCellToWin(DOT_O);
        if (cell == null) {
            // если не ход компьютера выиграет, то проверяем, выиграет ли пользователь:
            cell = getNextCellToWin(DOT_X);
            if (cell == null) {
                cell = randomCellForAITurn();
            }
        }

        int row = cell[0];
        int col = cell[1];
        System.out.println("Компьютер сделал ход в ячейку " + (row + 1) + " " + (col + 1));
        map[row][col] = DOT_O;
    }

    private static int[] getNextCellToWin(char symbol) {
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                //здесь проверяем для каждой ячейки, пустая ли она, и будет ли ход выигрышным
                if (map[rowIndex][colIndex] == DOT_EMPTY && isGameMoveWinning(rowIndex, colIndex, symbol)) {
                    // возвращаем массив с координатами, если оба условия выполнены
                    return new int[]{rowIndex, colIndex};
                }
            }
        }
        // или же возвращаем пустое значение
        return null;
    }

    private static boolean isGameMoveWinning(int rowIndex, int colIndex, char symbol) {
        // метод берёт координаты из метода getNextCellToWin() и подставляет соответствующий символ в эти координаты
        map[rowIndex][colIndex] = symbol;
        //затем проверяет, а будет ли при этом игра выиграна
        boolean result = checkWin(symbol);
        // после чего ячейка снова опустошается
        map[rowIndex][colIndex] = DOT_EMPTY;
        // и возвращаем правду, если ход победный, и ложь, если нет
        return result;
    }

    private static int[] randomCellForAITurn() {
        int row, col;
        do {
            // используем do while, чтобы прошла хотя бы одна итерация цикла
            // с помощью метода rand.nextInt(size) возвращаем случайное число от 0 до (size - 1)
            row = rand.nextInt(size);
            col = rand.nextInt(size);
        } while (!isCellValid(row, col)); // проверяем, свободна ли клетка
        return new int[]{row, col}; // возвращаем координаты клетки
    }


    public static boolean isCellValid(int row, int col) {
        // проверяем валидность координат
        if (col < 0 || col >= size || row < 0 || row >= size) return false;
        // проверяем, свободна ли ячейка для хода
        if (map[row][col] == DOT_EMPTY) return true;
        return false;
    }

    private static boolean checkWinRowsAndColumns(char symb) {
        for (int i = 0; i < size; i++) {
            int rowCounter = 0; // сбрасываем счётчик на каждой итерации цикла, иначе он прибавит к двум предыдущим символам первый следующий
            int colCounter = 0; // сбрасываем счётчик на каждой итерации цикла, иначе он прибавит к двум предыдущим символам первый следующий
            for (int j = 0; j < size; j++) {
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
        for (int i = 0; i < size; i++) {
            if (map[i][i] == symb) {
                diag1Counter = diag1Counter + 1;
            } else {
                diag1Counter = 0;
            }

            if (map[i][size - 1 - i] == symb) {
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
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
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
        // если карта полная, но выигрыша нет, то печатаем сообщение о ничье.
        // Этот код нельзя ставить первым, т.к. при выигрыше на последнем ходе, он печатает ничью. ???
        if (isMapFull()) {
            System.out.println(DRAW_MSG);
            return true;
        }
        // печатаем выражение о выигрыше либо компьютера, либо человека.
        if (checkWin(symbol)) {
            System.out.println(getWinMessageBy(symbol));
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
