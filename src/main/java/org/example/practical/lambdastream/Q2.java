package org.example.practical.lambdastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2 {

    public static void main(String[] args) {

        List<Integer> integerList= Arrays.asList(15,22,36,45,65,64,7,81,90);
        List<Integer> evenNumbers = integerList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        evenNumbers.forEach(System.out::println);

    }


}
