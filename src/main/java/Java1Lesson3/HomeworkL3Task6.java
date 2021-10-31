package Java1Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkL3Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Конечно, по-хорошему, здесь нужна проверка на ввод. Но я действительно не понимаю пока, как это сделать.
        // Нужно этот момент доработать.
        // Далее в коде идут мои комментарии, которые мне нужны для понимания работы данного кода.
        System.out.println("Введите числа через пробел,для подтверждения нажмите клавишу Enter.\n" +
                "Числа должны быть целыми. Если всё правильно сделаете - получите конфетку!");
        String input = sc.nextLine(); // Пользователь вводит числа, которые записываются в переменную в виде строки.
        String[] numbers = input.split("\\s+"); // Создаём (возвращаем) массив, который разбивает
        // предыдущую строку на элементы по пробелу или нескольким пробелам,
        // при этом, если первый случайно введён пробел, пробел идёт в массив первым элементом
        // и в дальнейшем при переводе строки в числа выдаёт ошибку

        int[] numericArray = new int[numbers.length]; // Создаём массив для числового ряда из нашей введённой строки
        for (int j = 0; j < numbers.length; j++) {
            numericArray[j] = Integer.parseInt(numbers[j]); // Метод parseInt() преобразует строку в число
        }
        System.out.println();
        System.out.printf("Обещанная конфетка -->  %c%c%c\n", '▷', '◯', '◁');
        System.out.println();
        System.out.println("Введённые числа: " + Arrays.toString(numericArray));
        System.out.println();
        System.out.println("Минимальное число в этом ряду: " + checkMinValue(numericArray));
        System.out.println("Максимальное число в этом ряду: " + checkMaxValue(numericArray));
        System.out.println();
        System.out.println("   ***   \n");
        checkAndPrintMinAndMaxVolume(numericArray);

    }

    private static void checkAndPrintMinAndMaxVolume(int[] numericArray) {
        System.out.println("Вариант второй, с помощью сортировки:\n");
        Arrays.sort(numericArray); // Расставляет элементы в массиве по возрастанию.
        // Вопрос: нужно ли перед этим делать копию первоначального массива? В данном случае код работает.
        System.out.println("Минимальное число в этом ряду: " + numericArray[0]);
        System.out.println("Максимальное число в этом ряду: " + numericArray[numericArray.length - 1]);
    }

    public static int checkMinValue(int[] numericArray) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numericArray.length; i++) {
            if (numericArray[i] < min) {
                min = numericArray[i];
            }
        }
        return min;
    }

    public static int checkMaxValue(int[] numericArray) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numericArray.length; i++) {
            if (numericArray[i] > max) {
                max = numericArray[i];
            }
        }
        return max;

    }
}

