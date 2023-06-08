package org.java.functional.programming.jdk8;

import org.java.functional.programming.common.Department;
import org.java.functional.programming.common.Employee;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReduceOperations {
    public int sumOfSalary(Collection<Employee> employees) {
        return employees.stream()
                        .mapToInt(Employee::getSalary)
                        .sum();
    }

    public Map<Department, Integer> sumOfSalaryPerDepartment(Collection<Employee> employees) {
        return employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
    }

    public Map<String, Long> countStringOccurrences(Collection<String> collection) {
        return collection
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public Map<String, Long> countCharacterOccurrences(String value) {
        return value.chars()
                    .mapToObj(Character::toString)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
