package org.example.practical.lambdastream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q9 {
    public static void main(String[] args) {

        List<Integer> integerList= Arrays.asList(15,22,36,45,65,64,7,81,90);
        long count = integerList.stream().filter(integer -> integer % 2 == 0).count();
        System.out.println(count);
    }
}
