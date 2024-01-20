package ru.geekbrains.junior.lesson1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/*Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.*/
public class Task1 {
    public static double getAverageOfEvens(List<Integer> numbers) {
        return numbers.stream()
                .filter(e -> e % 2.0 == 0)
                .mapToDouble(e -> (double) e)
                .average()
                .getAsDouble();
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,5);
        double avgEvens = getAverageOfEvens(nums);
        System.out.println(avgEvens);

    }
}
