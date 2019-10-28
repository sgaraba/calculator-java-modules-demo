package com.esempla.calculator;

import com.esempla.lib.Math;

public class Demo {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("Enter two integer!");
        } else {
            final Integer a = Integer.valueOf(args[0]);
            final Integer b = Integer.valueOf(args[1]);

            System.out.printf("sum(%d, %d) = %d\n", a, b, Math.sum(a, b));
            System.out.printf("substract(%d, %d) = %d\n", a, b, Math.substract(a, b));
            System.out.printf("divide(%d, %d) = %d\n", a, b, Math.divide(a, b));
            System.out.printf("multiply(%d, %d) = %d\n", a, b, Math.multiply(a, b));
        }
    }
}
