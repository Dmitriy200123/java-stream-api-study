import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        solveTask();

        solveTask2();
    }

    private static void solveTask(){
        var result = new Random()
                .ints(1000, 10, 10000)
                .boxed()
                .toList();

        System.out.println(new Random()
                .ints(1000, 10, 10000)
                .count());

        System.out.println(new Random()
                .ints(1000, 10, 10000)
                .reduce(Integer::sum));

        new Random()
                .ints(1000, 10, 10000)
                .forEach(System.out::println);

        var map = new Random()
                .ints(1000, 10, 10000)
                .boxed()
                .sorted()
                .filter(e -> e > 100 && e < 500)
                .limit(10)
                .map(e -> e * 5)
                .distinct()
                .collect(Collectors.toMap(Object::toString, e -> e));
    }

    private static void solveTask2(){
        var strings = List.of("453543first", "second2324354", "2456thi343rd");

        System.out.println(strings
                .stream()
                .map(e -> e.replaceAll("\\d", ""))
                .collect(Collectors.joining(" ")));

        strings
                .stream()
                .filter(e -> e.contains("first"))
                .forEach(System.out::println);

        System.out.println(strings
                .stream()
                .dropWhile(e -> e.contains("thi"))
                .count());

        System.out.println(strings
                .stream()
                .map(e -> List.of(e.replaceAll("\\p{L}", "").split("")))
                .flatMap(List::stream)
                .map(Integer::parseInt)
                .reduce(Integer::sum));
    }
}