package Java1Lesson5;

public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;
    private String position;
    private int salary;

    /* Я не совсем поняла, всегда ли нужно создавать руками дефолтный конструктор для обеспечения перегрузки конструкторов?
    public Employee () {
    }
    */

    public Employee(String firstName, String middleName, String lastName, int age, String phoneNumber, String email, String position, int salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void employeePrintInfo() {
        System.out.println("Сотрудник: " + this.lastName + " " + this.firstName + " " + this.middleName + '\n'
                + "Возраст:" + this.age + '\n'
                + "E-mail: " + this.email + ", телефон: " + this.phoneNumber + '\n'
                + "Работает в должности: \"" + this.position + "\" с зарплатой: " + this.salary + " рублей"
        );
    }


}


