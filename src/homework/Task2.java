package homework;

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
            for (int i = 0, j = 1; i < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    System.out.printf("[%d, %d]", array[i], array[j]);
                    break;
                }

                if (j == array.length - 1) {
                    j = i + 1;
                    i++;
                }
            }

        } else {
            System.out.println("Array is null or its size less than 2");
        }
    }
}
