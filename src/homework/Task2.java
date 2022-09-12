package homework;

import java.util.HashMap;
import java.util.Map;

public class Task2 {

    /*
    Task2

        [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
     */

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 7};
        printPair(array, 10);
    }

    public static void printPair(int[] array, int sum) {
        if (array != null && array.length > 1) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(sum - array[i])) {
                    System.out.printf("[%d, %d]", array[map.get(sum - array[i])], array[i]);
                    break;
                }

                map.put(array[i], i);
            }

            System.out.println("Pair is not found");

        } else {
            System.out.println("Array is null or its size less than 2");
        }
    }
}
