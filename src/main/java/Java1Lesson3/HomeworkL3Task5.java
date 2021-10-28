package Java1Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkL3Task5 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(requiredArray()));
    }

    public static int[] requiredArray() {
//В будущем хорошо бы сделать защиту от желающих ввести что-нибудь не то...
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число, обозначающее длину массива:");
        int len = sc.nextInt();
        System.out.println("Введите целое число для внутренних элементов массива:");
        int initialValue = sc.nextInt();
        sc.close();

        int[] array = new int[len];
        /* Пошаговый вариант:
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        } */
        Arrays.fill(array, initialValue);
        return array;

    }

}

