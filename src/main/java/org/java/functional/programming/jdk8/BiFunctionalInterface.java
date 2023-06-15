package org.java.functional.programming.jdk8;

import org.java.functional.programming.common.Department;
import org.java.functional.programming.common.Employee;

import java.util.Objects;
import java.util.function.BiFunction;

public class BiFunctionalInterface {

    private static final java.util.function.BiFunction<Employee, Department, String> VALIDATE_DEPARTMENT = (e, d) -> {
        if (Objects.isNull(e.getDepartment())) {
            return "Department is null";
        }
        return null;
    };

    private static final java.util.function.BiFunction<Employee, Department, String> VALIDATE_SALARY = (e, d) -> {
        if (Objects.isNull(e.getSalary())) {
            return "Salary is null";
        }
        return null;
    };

    private static BiFunction<Integer, Integer, Integer> SUM = (a,b) -> {
        return Integer.sum(a,b);
    };
}
