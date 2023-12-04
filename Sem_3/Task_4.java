package Sem_3;

// Напишите обобщенный класс Pair, который представляет собой пару значений разного типа. Класс должен иметь методы getFirst(), getSecond() для получения значений
// пары, а также переопределение метода toString(), возвращающее строковое представление пары.

public class Task_4<T1, T2> {
    private T1 first;
    private T2 second;

    public Task_4(T1 key, T2 value) {
        this.first = key;
        this.second = value;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public String toString() {
        return first + ". " + second + ".";
    }

    public static void main(String[] args){
        Task_4<Integer, String> person1 = new Task_4<>(1, "Иванов Иван");
        Task_4<Integer, String> person2 = new Task_4<>(2, "Кушнир Наталья");
        Task_4<Integer, String> person3 = new Task_4<>(3, "Петров Петр");
        System.out.println("\nРезультат Task_4:");
        System.out.println(person1 + "\n" + person2 + "\n" + person3);
    }
}
