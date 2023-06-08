package org.java.functional.programming.jdk8;

import org.java.functional.programming.common.Department;
import org.java.functional.programming.common.Employee;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterWithCustomPredicate {

    private static Predicate<Employee> isHigherRangeSalary(int higherThanSalary) {
        return employee -> employee.getSalary() > higherThanSalary;
    }

    private static Predicate<Employee> isDepartmentAWS() {
        return employee -> employee.getDepartment()
                                   .equals(Department.AWS);
    }

    private static Predicate<Employee> isDepartmentOpenSourceCloud() {
        return employee -> employee.getDepartment()
                                   .equals(Department.OPEN_SOURCE_AND_CLOUD);
    }

    public List<Employee> filterDataBySalaryAndDesignation(Collection<Employee> employees, int higherThanSalary) {
        return employees.parallelStream()
                        .filter((isHigherRangeSalary(higherThanSalary).and(isDepartmentAWS()))
                                .or(isHigherRangeSalary(higherThanSalary).and(isDepartmentOpenSourceCloud())))
                        .collect(Collectors.toList());
    }
}

