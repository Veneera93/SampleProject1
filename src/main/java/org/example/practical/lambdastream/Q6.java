package org.example.practical.lambdastream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q6 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Mike", "Leo", "John", "Chai");
        List<String> jNames = names.stream().filter(name -> name.startsWith("J")).collect(Collectors.toList());
        jNames.forEach(System.out::println);
    }
}
