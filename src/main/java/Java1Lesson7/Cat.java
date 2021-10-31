package Java1Lesson7;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;

    }


    public void eat(Plate p) {
        p.decreaseFood(appetite);
        System.out.println(name + " поел и теперь сыт!");
        satiety = true;

    }



    public boolean isSatiety() {
        return satiety;
    }


    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }
}



