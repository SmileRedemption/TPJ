package Lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findMaxBinaryOnesPrime(int n) {
        int maxBinaryOnes = -1;
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                String binaryNumber = Integer.toBinaryString(i);
                int onesCount = binaryNumber.replace("0", "").length();

                if (onesCount == maxBinaryOnes){
                    result.add(i);
                }

                if (onesCount > maxBinaryOnes) {
                    maxBinaryOnes = onesCount;
                    result = new ArrayList<>();
                    result.add(i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 20;
        var result = findMaxBinaryOnesPrime(n);

        System.out.println("Просте число менше або рівне " + n +
                ", в якого максимальна кількість одиниць у двійковому представленні: " + Arrays.toString(result.toArray()));
    }
}

