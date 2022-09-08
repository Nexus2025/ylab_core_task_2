package homework;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Task1 {
    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Task1.Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Task1.Person[] RAW_DATA = new Task1.Person[]{
            new Task1.Person(0, "Harry"),
            new Task1.Person(0, "Harry"), // дубликат
            new Task1.Person(1, "Harry"), // тёзка
            new Task1.Person(2, "Harry"),
            new Task1.Person(3, "Emily"),
            new Task1.Person(4, "Jack"),
            new Task1.Person(4, "Jack"),
            new Task1.Person(5, "Amelia"),
            new Task1.Person(5, "Amelia"),
            new Task1.Person(6, "Amelia"),
            new Task1.Person(7, "Amelia"),
            new Task1.Person(8, "Amelia"),
    };

    /*
    Task1
        Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

        Что должно получиться
            Key:Amelia
            Value:4
            Key: Emily
            Value:1
            Key: Harry
            Value:3
            Key: Jack
            Value:1
     */

    public static void main(String[] args) {
        Consumer<Map<String, Long>> print = map -> {
            for(Map.Entry<String, Long> entry : map.entrySet()) {
                System.out.printf("Key: %s \nValue: %d\n", entry.getKey(), entry.getValue());
            }
        };

        convertToMap(RAW_DATA).ifPresentOrElse(print, () -> System.out.println("Array is null"));
    }

    public static Optional<Map<String, Long>> convertToMap(Task1.Person[] data) {
        if (data == null) {
            return Optional.empty();

        } else {
            return Optional.of(Arrays.stream(data)
                    .filter(Objects::nonNull)
                    .distinct()
                    .sorted(Comparator.comparing(Task1.Person::getId))
                    .collect(Collectors.groupingBy(Task1.Person::getName, Collectors.counting())));
        }
    }
}