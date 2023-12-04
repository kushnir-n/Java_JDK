package Sem_3;

//  Напишите обобщенный метод compareArrays(), который принимает два массива и
// возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть
// любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.

public class Task_3 {
    
    private static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("\nРезультат Task_3:");
        Integer[] intArray1 = { 1, 2, 3, 4, 5 };
        Integer[] intArray2 = { 1, 2, 3, 4, 5 };
        boolean result1 = compareArrays(intArray1, intArray2);
        System.out.println("- одинаковых целочисленных: " + result1);

        String[] stringArray1 = { "Иванов", "Иван" };
        String[] stringArray2 = { "Иванов", "Иван" };
        boolean result2 = compareArrays(stringArray1, stringArray2);
        System.out.println("- одинаковых строковых:     " + result2);

        Double[] doublesArray1 = { 1.1, 2.2, 3.3, 4.4 };
        Double[] doublesArray2 = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        boolean result3 = compareArrays(doublesArray1, doublesArray2);
        System.out.println("- с разной длиной:          " + result3);

        Float[] floatArray1 = { 1.1f, 2.2f, 3.3f, 4.4f };
        Float[] floatArray2 = { 2.2f, 3.3f, 4.4f, 5.5f };
        boolean result4 = compareArrays(floatArray1, floatArray2);
        System.out.println("- с разным содержанием:     " + result4);
    
    }
 
    
}