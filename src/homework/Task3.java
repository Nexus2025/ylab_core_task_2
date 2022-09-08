package homework;

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

    public static boolean fuzzySearch(String pattern, String line) {
        if (pattern == null || line == null || pattern.length() > line.length()) {
            return false;

        } else {
            int count = 0;
            int cursor = 0;
            char[] patternArr = pattern.toCharArray();
            char[] lineArr = line.toCharArray();

            loop:
            for (int i = 0; i < patternArr.length; i++) {
                if (cursor == lineArr.length) {
                    break;
                }

                for (int j = cursor; j < lineArr.length; j++) {
                    if (count == patternArr.length) {
                        break loop;
                    }

                    if (patternArr[i] == lineArr[j]) {
                        count++;
                        cursor = j + 1;
                        break;
                    }
                }
            }

            return count == patternArr.length;
        }
    }

    public static void test() {
        boolean actual1 = fuzzySearch("abc", "abc");
        assert actual1;

        boolean actual2 = fuzzySearch("", "");
        assert actual2;

        boolean actual3 = fuzzySearch(null, null);
        assert !actual3;

        boolean actual4 = fuzzySearch("abcd", "abc");
        assert !actual4;

        boolean actual5 = fuzzySearch("etcmod", "tcmode");
        assert !actual5;

        boolean actual6 = fuzzySearch("etcmodc", "etcmodv");
        assert !actual6;
    }
}