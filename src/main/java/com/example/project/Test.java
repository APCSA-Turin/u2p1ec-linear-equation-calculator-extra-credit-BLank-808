 package com.example.project;

public class Test {

    public static void main(String[] args) {
        LinearCalculator c = new LinearCalculator("(1,2)","(-1,-2)");
        System.out.print(c.findSymmetry());
    }
}