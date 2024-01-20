package ru.geekbrains.junior.lesson2.task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Barsik", 3, 4.325));
        animals.add(new Dog("Bobik", 7, 47.3));
        animals.add(new Dog("Jack", 15, 26.540));
        animals.add(new Cat("Marsi", 13, 3.515));

        for (Animal animal : animals) {
            Class<?> childClass = animal.getClass();
            Class<?> parentClass = childClass.getSuperclass();
            StringBuilder sb = new StringBuilder(childClass.getSimpleName());
            sb.append(" {");
            buildFieldsInfo(animal, parentClass, sb);
            buildFieldsInfo(animal, childClass, sb);
            sb.append("methods : {");
            buildMethodsInfo(animal, childClass, sb);
            sb.append("}");
            invokeMethods(animal, childClass, sb);
            System.out.println(sb);
        }
    }

    private static void buildFieldsInfo(Animal animal, Class<?> clazz, StringBuilder builder) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            builder.append(field.getName())
                    .append(" : ")
                    .append(field.get(animal))
                    .append(", ");
        }
    }

    private static void buildMethodsInfo(Animal animal, Class<?> clazz, StringBuilder builder) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            builder.append(method.getName())
                    .append(", ");
        }
    }

    private static void invokeMethods(Animal animal, Class<?> clazz, StringBuilder builder) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            builder.append(method.invoke(animal));
        }
    }
}
