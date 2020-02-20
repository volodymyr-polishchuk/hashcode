package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                Main.class.getClassLoader().getResource("main/a_example.in").getFile()
                        )
                )
        );
        reader.lines().forEach(System.out::println);
    }
}
