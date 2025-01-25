package org.example.practical.lambdastream;

import java.util.Arrays;
import java.util.List;

public class Q10 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mike", "Leo", "John", "Chai");
        System.out.print(String.join("-", names));
    }
}
