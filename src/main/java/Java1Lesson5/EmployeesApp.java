package Java1Lesson5;

public class EmployeesApp {
    private static final int REFERENCE_AGE = 40;

    public static void main(String[] args) {
        /* И ещё вопрос:
        Насколько важно весь код разбивать на совсем маленькие методы?
        Например, здесь нужно ли вынести из main создание "базы данных" сотрудников?
        Как лучше делать?
         */

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Михаил", "Фёдорович", "Романов", 30, "+1 (111) 111-11-11", "tsar.russkii@ripn.net", "Царь", 13000);
        employees[1] = new Employee("Иосиф", "Виссарионович", "Сталин", 58, "+2 (222) 222-22-22", "stalin@stalin.ru", "Генеральный и первый секретарь ЦК ВКП(б)", 10000);
        employees[2] = new Employee("Екатерина Мария Ромола", "ди Лоренцо", "де Медичи", 25, "+3 (333) 333-33-33", "black.queen@gouv.fr", "Королева", 40500);
        employees[3] = new Employee("Борис", "Николаевич", "Ельцин", 44, "+4 (444) 444-44-44", "president@mail.ru", "Президент", 15000);
        employees[4] = new Employee("Маргарет", "Альфредовна", "Тэтчер", 37, "+5 (555) 555-55-55", "the.iron.lady@gov.uk", "Премьер-министр", 3000);

        for (Employee employee : employees) {
            if (employee.getAge() > REFERENCE_AGE) {
                employee.employeePrintInfo();
                System.out.println("  --***--  ");
            }
        }
    }

}
