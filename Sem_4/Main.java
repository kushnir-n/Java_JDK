package Sem_4;

public class Main {
    public static void main(String[] args) {
        EmployeeActions actions = new EmployeeActions();
        actions.addEmployee(new Employee(1, "Кушнир Наталья",
                "+7-909-163-14-55", 10));
        actions.addEmployee(new Employee(2, "Иванов Иван",
                "+7-909-163-13-95", 9));

        System.out.println("\nПоиск сотрудника по табельному номеру:");
        System.out.println(actions.findById(2).toString().replace("[", "").replace("]", ""));

        System.out.println("\nВывод номера телефона сотрудника по имени:");
        System.out.println(actions.showPhoneByName("Иванов Иван"));

        System.out.println("\nПоиск сотрудника по стажу:");
        System.out.println(actions.findByExperience(10).toString().replace("[", "").replace("]", ""));

        System.out.println("\nДобавить нового сотрудника:");
        System.out.print(actions.addEmployee(new Employee(3, "Шишмакова Елена",
                "+7-909-163-88-11", 2)).toString().replace("[", "").replace(",", "").replace("]", ""));
    }

}
