package org.example.practical.lambdastream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q1 {

    public static void main(String[] args){

        //reverse the array names
        List<String> names= Arrays.asList("Mike","Leo","John","Chai");
        names.forEach(System.out::println);
        System.out.println("----------------------------");
        Collections.reverse(names);
        names.forEach(System.out::println);
        names.forEach(System.out::println);
    }
}
