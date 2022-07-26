package space.gavinklfong.demo.streamapi.challenge3;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Challenge3 {

    // Predicate: isOdd
    private static Predicate<Integer> isEven = value -> value % 2 != 0;

    // Supplier: Sorting ascending
    private static BinaryOperator<Integer> supplier = (x, y) -> (x > y) ? x : y;

    public static void main(String[] args) {

        List<Integer> integerList = generateArray(100);

        Optional<Integer> maxEvenMavlue = getMaxEvenValue(integerList);

        System.out.print("Número impar más grande: ");
        maxEvenMavlue.ifPresent(System.out::println);

        long count = getValuesGreaterThan(integerList, maxEvenMavlue.orElseThrow());

        System.out.println("Cantidad de números mayores que " + maxEvenMavlue.orElseThrow() + " : " + count);

    }

    public static List<Integer> generateArray(long size, Integer minValue, Integer maxValue){
        return new Random()
                .ints(size, minValue, maxValue)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> generateArray(long size){
        return new Random()
                .ints(size, Integer.MIN_VALUE, Integer.MAX_VALUE)
                .boxed()
                .collect(Collectors.toList());
    }

    public static long getValuesGreaterThan(List<Integer> values, Integer x){
        return values.stream()
                .filter(value -> value > x)
                .count();
    }

    public static Optional<Integer> getMaxEvenValue(List<Integer> list){
        return list.stream()
                .filter(isEven)
                .reduce(supplier);
    }
}


