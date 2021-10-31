package Java1Lesson7;
// В этом варианте сначала все коты кушают, а затем пробуем добавить корма.
import java.util.Scanner;

public class MainClassV2 {
    public static void main(String[] args) {
        Plate plate = createPlate();
        Cat[] cats = getCats();
        feedTheCats(cats, plate);

    }

    private static Plate createPlate() {
        Plate plate = new Plate(10);
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
        do {
            for (Cat a : cats) {
                if (!a.isSatiety()) {
                    if (plate.isFoodEnough(a.getAppetite())) {
                        a.eat(plate);
                        System.out.print("Теперь ");
                        plate.infoFoodQuantity();
                        System.out.println();

                    } else if (!a.isSatiety()) {
                        System.out.println("Кот " + a.getName() + " голоден, но еды мало, и он из вредности не стал есть из тарелки.\nОн такой голодный, что съел бы " + a.getAppetite() + " у.е. корма!");
                        System.out.print("Сейчас ");
                        plate.infoFoodQuantity();
                        System.out.println();

                    }

                } else {
                    System.out.println("Кот " + a.getName() + " уже ел!");
                    System.out.print("Сейчас ");
                    plate.infoFoodQuantity();
                    System.out.println();

                }

            }
            if (!inputDecision(cats)) {
                break;
            } else {

                plate.addSomeFood();

            }

        } while (isThereStarvingCats(cats));


        System.out.println();
        System.out.println("Вроде бы покормили всех, кого хотели!");
    }

    private static boolean isThereStarvingCats(Cat[] cats) {
        for (Cat a : cats) {
            if (!a.isSatiety()) {
                return true;
            }
        }
        return false;
    }


    private static boolean inputDecision(Cat[] cats) {
        if (isThereStarvingCats(cats)) {
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("Добавить немного корма?\n 1 - да, 2 - нет");
                String str1 = scanner.next();
                String str2 = "1";
                String str3 = "2";
                if (str1.equals(str2)) {
                    return true;
                } else if (str1.equals(str3)) {
                    System.out.println();
                    System.out.println("Пусть все вреднючки голодают!");
                    return false;
                }
            } while (true);
        } else {
            return false;
        }

    }


}
