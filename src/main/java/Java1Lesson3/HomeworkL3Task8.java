package Java1Lesson3;


import java.util.Arrays;
import java.util.Scanner;

public class HomeworkL3Task8 {

    public static void main(String[] args) {
        char[] changeableArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int n = inputVar();
        System.out.println(Arrays.toString(changeableArray));
        System.out.println("Величина сдвига = " + n);
        carouselForArray(changeableArray, n);

    }

    private static int inputVar() {
        //В будущем хорошо бы сделать защиту от желающих ввести что-нибудь не то...
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число, обозначающее величину сдвига (отрицательное значение для сдвига влево, положительное - для сдвига вправо: ");
        int n = sc.nextInt();
        sc.close();
        return n;
    }

    private static void carouselForArray(char[] changeableArray, int n) {
        if (n >= 0) {
            System.out.println(Arrays.toString(carouselForArrayRight(changeableArray, n)));
        } else {
            System.out.println(Arrays.toString(carouselForArrayLeft(changeableArray, n)));
        }
    }

    private static char[] carouselForArrayRight(char[] changeableArray, int n) {
        for (int k = 1; k <= Math.abs(n); k++) {
            char transferVar = changeableArray[changeableArray.length - 1];
            for (int i = changeableArray.length - 1; i > 0; i--) {
                changeableArray[i] = changeableArray[i - 1];
            }
            changeableArray[0] = transferVar;
        }

        return changeableArray;
    }

    private static char[] carouselForArrayLeft(char[] changeableArray, int n) {

        for (int k = 1; k <= Math.abs(n); k++) {
            char transferVar = changeableArray[0];
            for (int i = 0; i < changeableArray.length - 1; i++) {
                changeableArray[i] = changeableArray[i + 1];
            }
            changeableArray[changeableArray.length - 1] = transferVar;
        }
        return changeableArray;
    }
}

