package Sem_3;

// Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы: sum(), multiply(), divide(), subtract(). 
// Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.

public class Task_2 {

    public static <T extends Number> double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> double subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static <T extends Number> double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> double divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль не допустимо!");
        }
        return num1.doubleValue() / num2.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println("Результат Task_2:");
        System.out.println(Task_2.sum(5, 12.0));
        System.out.println(Task_2.multiply(7, 7));
        System.out.println(Task_2.divide(2, 2));
        System.out.println(Task_2.subtract(3, 3));
    }
}