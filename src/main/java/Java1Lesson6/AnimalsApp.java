package Java1Lesson6;

// Счётчик сделала не сама. Пыталась через отдельный класс Counter,
// чтобы он посчитал количество вызовов каждого метода, но запуталась.
// Разобрала Ваш вариант.


import java.util.Scanner;

public class AnimalsApp {
    public static void main(String[] args) {
        int runDistance = inputDistanceToRun();
        int swimDistance = inputDistanceToSwim();
        System.out.println();

        Animal[] pets = activePets();
        for (Animal a : pets) {
            a.run(runDistance);
            a.swim(swimDistance);
            System.out.println();
        }

        System.out.println();
        printInfoAboutPets();

    }

    private static Animal[] activePets() {
        return new Animal[]{
                new Cat("Барсик", 100),
                new Cat("Мурзятина", 130),
                new Dog("Шарик", 300, 6),
                new Cat ("Пушистик", 160),
                new Dog ("Тузик", 480, 233),
                new Cat (),
                new Dog (),
        };
    }


    private static int inputDistanceToRun() {
        int distanceToRun;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите длину дистанции в метрах, которую должно преодолеть животное по земле: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Длина должна быть задана целым числом! Введите длину дистанции снова: ");
                scanner.next();
            }
            distanceToRun = scanner.nextInt();
            break;
        } while (true);

        return distanceToRun;
    }

    private static int inputDistanceToSwim() {
        int distanceToSwim;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите длину дистанции в метрах, которую должно преодолеть животное по воде: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Длина должна быть задана целым числом! Введите длину дистанции снова: ");
                scanner.next();
            }
            distanceToSwim = scanner.nextInt();
            break;
        } while (true);

        return distanceToSwim;
    }

    private static void printInfoAboutPets() {
        System.out.println("Всего животных: " + Animal.getCount() + " шт.");
        System.out.println("Всего кошек: " + Cat.getCount() + " шт.");
        System.out.println("Всего собак: " + Dog.getCount() + " шт.");
    }
}

