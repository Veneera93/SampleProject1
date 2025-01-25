package org.example.practical.lambdastream;

import java.util.Random;
import java.util.function.Supplier;

public class Q5 {
    public static void main(String[] args) {

        Supplier<Integer> genRandom=()-> new Random().nextInt(10);
        for (int i = 0; i < 5; i++) {
            System.out.println(genRandom.get());
        }

    }
}
