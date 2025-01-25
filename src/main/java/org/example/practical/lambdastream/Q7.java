package org.example.practical.lambdastream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(4, 3, 8, 9, 2);
        List<Integer> squars = integerList.stream().map(integer -> (int) Math.pow(integer, 2)).collect(Collectors.toList());
        squars.forEach(System.out::println);
    }
}
