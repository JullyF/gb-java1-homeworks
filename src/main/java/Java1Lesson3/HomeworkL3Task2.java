package Java1Lesson3;

import java.util.Arrays;

public class HomeworkL3Task2 {
    public static void main(String[] args) {
        int[] myArray = new int[100];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray));


    }
}
