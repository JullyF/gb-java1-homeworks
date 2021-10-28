package Java1Lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class HomeworkL3Task4 {
    public static void main(String[] args) {

        //На будущее надо бы сделать проверку на ввод именно целого числа:
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер стороны для квадрата (целое число):");
        int squareSide = sc.nextInt();
        sc.close();
        System.out.println();

        //Для одной диагонали решение:
        int[][] squareArray = new int[squareSide][squareSide];
        for (int i = 0; i < squareArray.length; i++) {
            squareArray[i][i] = 1;
            System.out.println(Arrays.toString(squareArray[i]));
        }

        System.out.println();

        //Алгоритм вычисления второй диагонали подсмотрен в интернете.
        // Не вижу в этом ничего плохого, если есть понимание, как это работает. С математикой у меня не очень :).
        int[][] squareArrayV2 = new int[squareSide][squareSide];
        for (int i = 0; i < squareArrayV2.length; i++) {
            squareArrayV2[i][i] = 1;
            squareArrayV2[i][squareSide - 1 - i] = 1;
            System.out.println(Arrays.toString(squareArrayV2[i]));
        }
    }


}

