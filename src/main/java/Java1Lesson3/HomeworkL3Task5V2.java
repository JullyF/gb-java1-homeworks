package Java1Lesson3;

import java.util.Arrays;
import java.util.Scanner;

//Подскажите, пожалуйста, какой вариант предпочтительнее: HomeworkL3Task5 или HomeworkL3Task5V2???

public class HomeworkL3Task5V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число, обозначающее длину массива:");
        int len = sc.nextInt();
        System.out.println("Введите целое число для внутренних элементов массива:");
        int initialValue = sc.nextInt();
        sc.close();

        System.out.println(Arrays.toString(requiredArray(len, initialValue)));
    }

    public static int[] requiredArray(int len, int initialValue) {

        int[] array = new int[len];
        /* Пошаговый вариант:
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        } */
        Arrays.fill(array, initialValue);
        return array;

    }

}
