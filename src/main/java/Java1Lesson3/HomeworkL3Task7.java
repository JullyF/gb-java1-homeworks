package Java1Lesson3;

import java.util.Arrays;

public class HomeworkL3Task7 {
    public static void main(String[] args) {
        int[] myArray = {2, 10, 5, 5, 10, 2};
        System.out.println();
        if (checkEqualityLeftAndRightArraySidesSum(myArray)) {
            System.out.println("В массиве " + Arrays.toString(myArray) + " есть место, в котором сумма левой и правой части массива равны.");
        } else {
            System.out.println("В массиве " + Arrays.toString(myArray) + " нет места, в котором сумма левой и правой части массива равны.");
        }
        System.out.println();
        System.out.println("  ***  ");
        System.out.println();

        if (checkEqualityLeftAndRightArraySidesSumV2(myArray)) {
            System.out.println("В массиве " + Arrays.toString(myArray) + " есть место, в котором сумма левой и правой части массива равны.");
        } else {
            System.out.println("В массиве " + Arrays.toString(myArray) + " нет места, в котором сумма левой и правой части массива равны.");
        }

    }

    public static boolean checkEqualityLeftAndRightArraySidesSum(int[] myArray) {
        int sumArray = 0;
        for (int k : myArray) {
            sumArray += k;
        }
        int sumLeftSide = 0;
        for (int i = 0; i < myArray.length; i++) {
            sumLeftSide += myArray[i];
            if (sumLeftSide == sumArray - sumLeftSide) {
                return true;
            }

        }
        return false;
    }


    public static boolean checkEqualityLeftAndRightArraySidesSumV2(int[] myArray) {
        int sumRightSide = 0;
        for (int s : myArray) {
            sumRightSide += s;
        }

        int sumLeftSide = 0;

        for (int i = 0; i < myArray.length; i++) {
            sumLeftSide += myArray[i];
            sumRightSide -= myArray[i];
            if (sumLeftSide == sumRightSide) {
                return true;
            }
        }
        return false;
    }
}
