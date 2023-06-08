package org.java.functional.programming.jdk8;

import org.java.functional.programming.common.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {
    public Map<Boolean, List<Employee>> getPartitionedDataByHigherSalary(Collection<Employee> employees) {
        return employees.stream()
                        .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 2000));
    }
}
