package Lab7;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int n = 20;
        List<Integer> result = findMaxBinaryOnesPrime(n);

        System.out.println("Просте число менше або рівне " + n +
                ", в якого максимальна кількість одиниць у двійковому представленні: " + Arrays.toString(result.toArray()));
    }

    public static List<Integer> findMaxBinaryOnesPrime(int n) {
        int[] maxBinaryOnes = {-1};
        List<Integer> result = new ArrayList<>();

        IntStream.rangeClosed(1, n)
                .filter(Main::isPrime)
                .forEach(i -> {
                    String binaryNumber = Integer.toBinaryString(i);
                    int onesCount = binaryNumber.replace("0", "").length();

                    if (onesCount == maxBinaryOnes[0]) {
                        result.add(i);
                    }

                    if (onesCount > maxBinaryOnes[0]) {
                        maxBinaryOnes[0] = onesCount;
                        result.clear();
                        result.add(i);
                    }
                });

        return result;
    }

    public static boolean isPrime(int num) {
        return num > 1 && IntStream.range(2, (int) Math.sqrt(num) + 1).noneMatch(i -> num % i == 0);
    }
}
