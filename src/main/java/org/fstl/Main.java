package org.fstl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class Main {

    static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(
                new Employee("Loico", "Square", 5000.0, List.of("Project 1","Project 2"))
        );

        employees.add(
                new Employee("Armel", "Sauvy", 6000.0, List.of("Project 1","Project 3"))
        );

        employees.add(
                new Employee("Sonia", "Meids", 5500.0, List.of("Project 3","Project 4"))
        );

    }

    public static void main(String[] args) {

        System.out.println("******FOREACH********\n");
        //foreach
        Stream.of(employees).forEach(employee -> System.out.println(employee));

        System.out.println("++++++++MAP++++++++\n");
        //map
        //Collect
        List<Employee> increasedSalary =
                employees.stream()
                        .map(employee -> new Employee(
                            employee.getFirstname(),
                            employee.getLastname(),
                                employee.getSalary() * 10 ,
                            employee.getProjects()
                        ))
                        .collect(Collectors.toList()); //toSet, toList, to ce qu'on veut.
        System.out.println(increasedSalary);

        System.out.println("-------FILTER-------\n");

        //Filter
        List<Employee> filterEmployees = employees
                .stream()
                .filter(employee -> employee.getSalary() > 5000)
                .map(employee -> new Employee(
                        employee.getFirstname(),
                        employee.getLastname(),
                        employee.getSalary() * 10 ,
                        employee.getProjects()
                ))
                .collect(Collectors.toList());
        System.out.println(filterEmployees);

        System.out.println("*-*-**-*-*FIRST EMPLOYEE *-*-*-*-*-*\n");

        Employee firstEmployee = employees
                .stream()
                .filter(employee -> employee.getSalary() > 5000)
                .map(employee -> new Employee(
                        employee.getFirstname(),
                        employee.getLastname(),
                        employee.getSalary() * 10 ,
                        employee.getProjects()
                ))
                .findFirst()
                .orElse(null);
        System.out.println("The first employee is \n" +firstEmployee.toString());

        System.out.println("*/*/*/*/*/*/*/FLAT MAP */*/*/*/*/*/\n");

        //flatMap
        String projects =
                employees
                        .stream()
                        .map(employee -> employee.getProjects())
                        .flatMap(strings -> strings.stream())
                        .collect(Collectors.joining(","));
        System.out.println(projects);

        System.out.println("*-*-**-*-* SHORT CIRCUIT OPERATIONS *-*-*-*-*-*\n");

        //short Circuit operations
        List<Employee> shortCircuit =
                employees
                        .stream()
                        .skip(1) // Just byPass the first element
                        .limit(1) // Limit just to One Element
                        .collect(Collectors.toList());
        System.out.println(shortCircuit);


        System.out.println("*-*-**-*-* FINITE DATA *-*-*-*-*-*\n");
        //Finite Data
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value -> System.out.println(value));

        System.out.println("*-*-**-*-* sorting *-*-*-*-*-*\n");
        //sorting
        List<Employee> sortedEmployees =
                employees
                        .stream()
                        .sorted((o1, o2) -> o1.getFirstname()
                                .compareToIgnoreCase(o2.getFirstname()))
                        .collect(Collectors.toList());
        System.out.println(sortedEmployees);


        System.out.println("*-*-**-*-* MIN or MAX *-*-*-*-*-*\n");

        //min or max
        employees
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("*-*-**-*-* reduce *-*-*-*-*-*\n");

        //reduce
        Double totalSal =
                employees
                        .stream()
                        .map(employee -> employee.getSalary())
                        .reduce(0.0,Double::sum);
        System.out.println(totalSal);

    }

}