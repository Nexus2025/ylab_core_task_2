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
        if (array != null) {
            for (int k : array) {
                for (int i : array) {
                    if (k + i == sum) {
                        System.out.printf("[%d, %d]", k, i);
                        return;
                    }
                }
            }
        }
    }
}
