package Java1Lesson6;

public class Cat extends Animal {
    public static final int CAT_RUN_ENDURANCE = 200;
    public static final int CAT_SWIM_ENDURANCE = 0;
    public static final String CAT_NAME = "Безымянный кот";

    public static int count;



    public Cat(String name, int runEndurance) {
        super(name, runEndurance, CAT_SWIM_ENDURANCE);
        count++;
    }


    public Cat() {
        super(CAT_NAME, CAT_RUN_ENDURANCE, CAT_SWIM_ENDURANCE);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int runDistance) {
        if (runDistance <= runEndurance) {
            System.out.println(name + " пробежал " + runDistance +
                    " м.");
        } else {
            System.out.println(name + " не может пробежать " + runDistance +
                    " м. Максимально " + name + " может пробежать " + runEndurance +
                    " м.");
        }
    }

    @Override
    public void swim(int swimDistance) {
                    System.out.println("Коты, конечно, плавать умеют, но не любят. " + name + " в воду не полез.");
        }
    }


