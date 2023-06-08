package org.java.functional.programming.example6;

import org.assertj.core.api.Assertions;
import org.java.functional.programming.common.Department;
import org.java.functional.programming.common.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PartitioningByTest {
    private final PartitioningBy subject = new PartitioningBy();

    private static Stream<Arguments> getTestData() {
        return Stream.of(
                Arguments.of(getEmployeeData(), 1500, getExpected())
        );
    }

    private static Map<Boolean, List<Employee>> getExpected() {

        return Map.of(
                true, List.of(
                        getEmployee("Employee 1", Department.OPEN_SOURCE_AND_CLOUD, 2700),
                        getEmployee("Employee 3", Department.AZURE, 4000)),
                false, List.of(
                        getEmployee("Employee 4", Department.OPEN_SOURCE_AND_CLOUD, 1100),
                        getEmployee("Employee 2", Department.AWS, 2000))
        );

    }

    private static Collection<Employee> getEmployeeData() {
        return List.of(
                getEmployee("Employee 1", Department.OPEN_SOURCE_AND_CLOUD, 2700),
                getEmployee("Employee 2", Department.AWS, 2000),
                getEmployee("Employee 3", Department.AZURE, 4000),
                getEmployee("Employee 4", Department.OPEN_SOURCE_AND_CLOUD, 1100)
        );
    }

    private static Employee getEmployee(String name, Department department, int salary) {
        return Employee.builder()
                .name(name)
                .department(department)
                .salary(salary)
                .build();
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void test_filter(Collection<Employee> employees, int higherThanSalary, Map<Boolean, List<Employee>> expected) {
        Map<Boolean, List<Employee>> actual = subject.getPartitionedDataByHigherSalary(employees);
        Assertions.assertThat(actual)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expected);
    }

}
