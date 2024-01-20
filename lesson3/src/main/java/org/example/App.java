package org.example;

import java.io.IOException;

import static org.example.StudentUtils.convertToFile;
import static org.example.StudentUtils.convertToObject;

public class App {
    public static void main(String[] args) throws IOException {
        Student student = new Student("Petr", 27, 4.7);
        convertToFile(".bin", student);
        convertToFile(".xml", student);
        convertToFile(".json", student);
        Student student1 = convertToObject("file.bin");
        System.out.println(student1);

    }
}