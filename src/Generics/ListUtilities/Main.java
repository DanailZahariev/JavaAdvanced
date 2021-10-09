package Generics.ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(13, 55, 232, 420);
        List<String> stringList = List.of("text", "word", "hello");
        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(stringList));
    }
}
