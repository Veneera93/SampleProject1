package org.example.practical.lambdastream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Q8 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(15, 22, 36, 45, 65, 64, 7, 81, 90);
        Optional<Integer> max = integerList.stream().max(Integer::compareTo);
        System.out.println(max.get());
    }
}
