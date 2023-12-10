package Sem_4;

// Задание 1. Создать справочник сотрудников
// Необходимо:
// ● Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
// ○ Табельный номер
// ○ Номер телефона
// ○ Имя
// ○ Стаж
// ● Добавить метод, который ищет сотрудника по стажу (может быть список)
// ● Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
// ● Добавить метод, который ищет сотрудника по табельному номеру
// ● Добавить метод добавление нового сотрудника в справочник

public class Employee {
    int id;
    String phone;
    String name;
    int experience;

    public Employee(int id, String name, String phone, int experience) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "№ сотрудника: " + id + "; Имя: " + name + "; Номер телефона: " + phone +
                "; Стаж: " + experience + " лет/года.\n";
    }

}
