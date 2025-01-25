package org.example.practical.lambdastream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {

    public static void main(String[] args) {
        List<String> names= Arrays.asList("Mike","Leo","John","Chai");
        List<String> uppercaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        uppercaseNames.forEach(System.out::println);
    }
}
