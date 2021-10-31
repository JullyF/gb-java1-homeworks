package Java1Lesson7;

import java.util.Scanner;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean isFoodEnough(int n) {
        if (food < n) {
            System.out.println("В тарелке недостаточно корма.");
            return false;
        } else {
            return true;
        }
    }

    public void decreaseFood(int n) {
        food -= n;

    }


    public void addSomeFood() {
        food += inputSomeFood();

    }

    public int inputSomeFood() {
        Scanner scanner = new Scanner(System.in);
        int newfood;


        System.out.println("Введите целое число условных единиц корма для котов:");
        while (!scanner.hasNextInt()) {
            System.out.println("Количество корма нужно задать целым числом! Попробуйте снова: ");
            scanner.next();
        }
        newfood = scanner.nextInt();


        return newfood;

    }


    public void infoFoodQuantity() {
        System.out.println("в тарелке " + food + " у.е. корма.");
    }


}


