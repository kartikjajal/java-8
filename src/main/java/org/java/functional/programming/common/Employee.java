package org.java.functional.programming.common;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Employee {
    private String name;
    private Department department;
    private Integer salary;
}
