package LabGenerics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Jar<String> stringJar = new Jar<>();

        stringJar.add("Pesho");
        stringJar.add("Ivan");


    }
}
