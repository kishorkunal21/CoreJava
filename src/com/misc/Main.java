package com.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String s = "abcdabc def";
        //countChar(s);

        //order it by salary desc, name asc
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "E1", 100));
        employees.add(new Employee(2, "E2", 200));
        employees.add(new Employee(3, "E3", 400));
        employees.add(new Employee(4, "A4", 400));
        emp(employees);

    }
    private static void emp(List<Employee> employees) {
        //order it by salary desc, name asc
        System.out.println(employees);
        employees.sort(Comparator.comparing(Employee::salary).reversed()
                .thenComparing(Employee::name));
        System.out.println("sorted ; "+employees);

    }
        private static void countChar(String s){
        String ignore ="[]%()";
        //s.replaceAll(, )
        //pattern.match = [0-9][a-b][A-Z]
        Stream.of(s).map(a->a.split(""))
                .flatMap(Arrays::stream)
                .filter(c->!ignore.contains(c))
                .collect(Collectors.toMap(k->k,v->1,(a,b)->a+1 ))
                .forEach((k,v)-> System.out.println(k+v));

    }
}
