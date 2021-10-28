package Java1Lesson3;

import java.util.Arrays;

public class HomeworkL3Task3 {
    public static void main(String[] args) {
        int[] anotherArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int index = 0; index < anotherArray.length; index++) {
            if (anotherArray[index] < 6) {
                anotherArray[index] *= 2;
            }
        }
        System.out.println(Arrays.toString(anotherArray));
        System.out.println();

        // Выяснить, почему foreach не меняет первый элемент в массиве, а остальные - меняет.
        // В мануале указано, что этот цикл вообще не предназначен для изменения элементов.
        // Не забыть спросить про это.

        System.out.println("Умножаем элементы, но не изменяем сам массив\n(в условиях не сказано, нужно ли менять массив или просто произвести арифметические действия)");
        int[] anotherArrayV2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int k : anotherArrayV2) {
            if (k < 6) {
                System.out.print(k * 2 + "  ");
            } else {
                System.out.print(k + "  ");
            }

        }
        System.out.println();
        System.out.println(Arrays.toString(anotherArrayV2));
    }
}



