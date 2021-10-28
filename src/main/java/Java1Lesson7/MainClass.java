package Java1Lesson7;
// В этом варианте я предлагаю докормить котов при каждом недостатке еды в тарелке.
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Plate plate = createPlate();
        Cat[] cats = getCats();
        feedTheCats(cats, plate);

    }

    private static Plate createPlate() {
        Plate plate = new Plate(30);
        System.out.print("Сейчас ");
        plate.infoFoodQuantity();
        return plate;
    }

    private static Cat[] getCats() {
        return new Cat[]{
                new Cat("Пушистик", 12),
                new Cat("Маркиз", 35),
                new Cat("Дымок", 23),
                new Cat("Масюшка", 15)
        };
    }

    private static void feedTheCats(Cat[] cats, Plate plate) {
        for (Cat a : cats) {
            do {
                if (!a.isSatiety()) {
                    if (plate.isFoodEnough(a.getAppetite())) {
                        a.eat(plate);
                        System.out.print("Теперь ");
                        plate.infoFoodQuantity();
                        System.out.println();
                        break;
                    } else if (!a.isSatiety()) {


                        System.out.println("Кот " + a.getName() + " голоден, но еды мало, и он из вредности не стал есть из тарелки.\nОн такой голодный, что съел бы " + a.getAppetite() + " у.е. корма!");
                        System.out.print("Сейчас ");
                        plate.infoFoodQuantity();
                        System.out.println();

                        if (!inputDecision()) {
                            break;
                        } else {

                            plate.addSomeFood();
                        }
                    }

                } else {
                    // В данном варианте этот код избыточен, конечно. Оставила на случай, если у нас будет (неожиданно)
                    // изначально сытый кот
                    System.out.println("Кот " + a.getName() + " не голоден!");
                    System.out.print("Сейчас ");
                    plate.infoFoodQuantity();
                    System.out.println();
                    break;
                }

            } while (true);

        }
        System.out.println();
        System.out.println("Вроде бы покормили всех, кого хотели!");

    }

    private static boolean inputDecision() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Добавить немного корма?\n 1 - да, 2 - нет");
            String str1 = scanner.next();
            String str2 = "1";
            String str3 = "2";
            if (str1.equals(str2)) {
                return true;
            } else if (str1.equals(str3)) {
                System.out.println("Пусть голодает!");
                return false;
            }
        } while (true);
    }


}


