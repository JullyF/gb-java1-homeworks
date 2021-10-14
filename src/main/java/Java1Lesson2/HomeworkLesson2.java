package Java1Lesson2;

public class HomeworkLesson2 {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        /* Вариант первый, где выполняем пошагово:
        if (checkSumWithin10and20(13, 10) == true) {
            System.out.println("Да, сумма указанных чисел лежит в промежутке от 10 до 20 на числовой прямой");
        } else {
            System.out.println("Нет, сумма указанных чисел не лежит в промежутке от 10 до 20 на числовой прямой");
        } */

        //Вариант второй, упрощённый:
        if (checkSumWithin10and20V2(13, 10)) {
            System.out.println("Да, сумма указанных чисел лежит в промежутке от 10 до 20 на числовой прямой");
        } else {
            System.out.println("Нет, сумма указанных чисел не лежит в промежутке от 10 до 20 на числовой прямой");
        }

        System.out.println();
        System.out.println("Задание 2");

        checkPositiveOrNegative(-1);

        System.out.println();
        System.out.println("Задание 3");
        if (isPositive(0)) {
            System.out.println("Загаданное число является положительным");
        } else {
            System.out.println("Загаданное число является отрицательным");
        }

        System.out.println();
        System.out.println("Задание 4");
        printMyTextSeveralTimes("Тут могла быть ваша реклама", 3);

        System.out.println();
        System.out.println("Задание 5*");
        if (checkLeapYear(0)) {
            System.out.println("Это високоскный год");
        } else {
            System.out.println("Год не является високосным");
        }


    }

    //Для первого (пошагового) варианта.
    /* Понятно, что тут избыточный код, но это нужно мне для понимания логики процесса:
    public static boolean checkSumWithin10and20(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    } */

    //Для второго (упрощённого) варианта:
    public static boolean checkSumWithin10and20V2(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void checkPositiveOrNegative(int c) {
        if (c >= 0) {
            System.out.println("Число " + c + " является положительным");
        } else {
            System.out.println("Число " + c + " является отрицательным");
        }
    }

    public static boolean isPositive(int d) {
        return d >= 0;
    }


    public static void printMyTextSeveralTimes(String txt, int f) {
        for (int i = 0; i < f; i++) {
            System.out.println(txt);
        }
    }
//В этом задании хорошо бы ещё учесть варианты "до нашей эры",
// указав момент, с какого года началось исчисление високосных годов,
// но я не знаю, как это сделать. И не знаю, как в случае с boolean грамотно оформить проверку на 0.
    public static boolean checkLeapYear(int g) {
        if (g != 0) {
            return ((g % 4 == 0 && g % 100 != 0) || g % 400 == 0);
        } else {
            System.out.println("Такого года не существует, но если бы он существовал, то Вы бы увидели сообщение: ");
            return true;
        }
    }
}
