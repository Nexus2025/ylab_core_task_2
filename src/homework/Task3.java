package homework;

import java.util.Arrays;

public class Task3 {

    /*
    Task3
        Реализовать функцию нечеткого поиска
                fuzzySearch("car", "ca6$$#_rtwheel"); // true
                fuzzySearch("cwhl", "cartwheel"); // true
                fuzzySearch("cwhee", "cartwheel"); // true
                fuzzySearch("cartwheel", "cartwheel"); // true
                fuzzySearch("cwheeel", "cartwheel"); // false
                fuzzySearch("lw", "cartwheel"); // false
     */

    public static void main(String[] args) {
        test();

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }

    public static boolean fuzzySearch(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() > str.length()) {
            return false;

        } else {
            Boolean[] charsMatching = new Boolean[pattern.length()];
            for (int i = 0, j = 0; i < pattern.length() && j < str.length(); j++) {
                if (pattern.charAt(i) == str.charAt(j)) {
                    charsMatching[i] = true;
                    i++;
                }
            }

            return Arrays.stream(charsMatching).allMatch(e -> e != null && e == true);
        }
    }

    public static void test() {
        boolean actual1 = fuzzySearch("abc", "abc");
        assert actual1;

        boolean actual2 = fuzzySearch("", "");
        assert actual2;

        boolean actual3 = fuzzySearch(" ", "etc modv");
        assert actual3;

        boolean actual4 = fuzzySearch(null, null);
        assert !actual4;

        boolean actual5 = fuzzySearch("abcd", "abc");
        assert !actual5;

        boolean actual6 = fuzzySearch("etcmod", "tcmode");
        assert !actual6;

        boolean actual7 = fuzzySearch("etcmodc", "etcmodv");
        assert !actual7;
    }
}