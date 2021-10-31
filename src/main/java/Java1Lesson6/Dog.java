package Java1Lesson6;

public class Dog extends Animal {
    public static final int DOG_RUN_ENDURANCE = 500;
    public static final int DOG_SWIM_ENDURANCE = 10;
    public static final String DOG_NAME = "Безымянный пёс";

    public static int count;

    public Dog (String name, int runEndurance, int swimEndurance) {
        super(name, runEndurance, swimEndurance);
        count++;

    }

    public Dog () {
        super(DOG_NAME, DOG_RUN_ENDURANCE, DOG_SWIM_ENDURANCE);
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
        }else {
            System.out.println(name + " не может пробежать " + runDistance +
                    " м. Максимально " + name + " может пробежать " + runEndurance +
                    " м.");
        }
    }

    @Override
    public void swim(int swimDistance) {
        if (swimDistance <= swimEndurance) {
            System.out.println(name + " проплыл " + swimDistance +
                    " м.");
        }else {
            System.out.println(name + " не может проплыть " + swimDistance +
                    " м. Максимально " + name + " может проплыть " + swimEndurance +
                    " м.");
        }
    }

}
