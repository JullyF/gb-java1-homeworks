package Java1Lesson6;


public class Animal {
    public String name;
    public int runEndurance;
    public int swimEndurance;

    public static int count;


    public Animal(String name, int runEndurance, int swimEndurance) {
        this.name = name;
        this.runEndurance = runEndurance;
        this.swimEndurance = swimEndurance;

        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int runDistance) {
        System.out.println("Непонятно, что тут делает это животное.");

    }

    public void swim(int swimDistance) {
        System.out.println("Непонятно, что тут делает это животное.");
    }




}
