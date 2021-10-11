package Java1Lesson1;

public class HomeworkLesson1 {
    public static void main(String[] args) {
        System.out.println();
        printThreeWords();
        checkSumSign();
        printColor();
        //заготовка для варианта без else (второй способ решения)
        // printColorVariant2();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple\n");
    }

    public static void checkSumSign() {
        int a = 5, b = -7;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная\n");
        } else {
            System.out.println("Сумма отрицательная\n");
        }
    }

    public static void printColor() {
        int value = -101;
        if (value <= 0) {
            System.out.println("Красный\n");
        } else if (value <= 100) {    // Исправлено после проверки домашнего задания
            System.out.println("Жёлтый\n");
        } else {
            System.out.println("Зелёный\n");
        }

    }

   /* Второй способ решения задачи:
   public static void printColorVariant2() {
        int value = -5;
        if (value <= 0) {
            System.out.println("Красный\n");
        }
        if (value > 0 && value <= 100) {
                System.out.println("Жёлтый\n");
            }
        if (value > 100) {
                System.out.println("Зелёный\n");
            }
        } */

    public static void compareNumbers() {
        int a = -18, b = 47;
        if (a >= b) {
            System.out.println("a >= b\n");
        } else {
            System.out.println("a < b\n");
        }
    }
}
