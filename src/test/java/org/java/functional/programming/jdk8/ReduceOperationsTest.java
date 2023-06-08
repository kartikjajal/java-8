package org.java.functional.programming.jdk8;

import org.assertj.core.api.Assertions;
import org.java.functional.programming.common.Department;
import org.java.functional.programming.common.Employee;
import org.java.functional.programming.jdk8.ReduceOperations;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ReduceOperationsTest {
    private final ReduceOperations subject = new ReduceOperations();

    private static Employee getEmployee(String name, Department department, int salary) {
        return Employee.builder()
                       .name(name)
                       .department(department)
                       .salary(salary)
                       .build();
    }

    @Test
    void test_sumOfSalary() {
        int actual = subject.sumOfSalary(getEmployeeData());
        int expected = 8100;
        Assertions.assertThat(actual)
                  .isEqualTo(expected);
    }

    @Test
    void test_sumOfSalaryPerDepartment() {
        Map<Department, Integer> actual = subject.sumOfSalaryPerDepartment(getEmployeeData());
        Map<Department, Integer> expected = Map.of(
                Department.AWS, 2000,
                Department.AZURE, 4000,
                Department.OPEN_SOURCE_AND_CLOUD, 2100);

        Assertions.assertThat(actual)
                  .isEqualTo(expected);
    }

    @Test
    void test_countStringOccurrences() {
        Collection<String> words = List.of("Apple", "Cat", "Dog", "Apple", "Dog", "Fish", "Cargo", "Java", "C++", "Java");
        Map<String, Long> actual = subject.countStringOccurrences(words);
        Map<String, Long> expected = Map.of(
                "Apple", 2L,
                "Cat", 1L,
                "Dog", 2L,
                "Fish", 1L,
                "Cargo", 1L,
                "Java", 2L,
                "C++", 1L
        );
        Assertions.assertThat(actual)
                  .usingRecursiveComparison()
                  .ignoringCollectionOrder()
                  .isEqualTo(expected);
    }

    @Test
    void test_countCharacterOccurrences() {
        String value = "AabBCcAaasAsDFas";
        Map<String, Long> actual = subject.countCharacterOccurrences(value);
        Map<String, Long> expected = Map.of(
                "A", 3L,
                "B", 1L,
                "C", 1L,
                "D", 1L,
                "F", 1L,
                "a", 4L,
                "b", 1L,
                "c", 1L,
                "s", 3L);
        Assertions.assertThat(actual)
                  .usingRecursiveComparison()
                  .ignoringCollectionOrder()
                  .isEqualTo(expected);
    }

    private Collection<Employee> getEmployeeData() {
        return List.of(
                getEmployee("Employee 1", Department.OPEN_SOURCE_AND_CLOUD, 1000),
                getEmployee("Employee 2", Department.AWS, 2000),
                getEmployee("Employee 3", Department.AZURE, 4000),
                getEmployee("Employee 4", Department.OPEN_SOURCE_AND_CLOUD, 1100));
    }
}


