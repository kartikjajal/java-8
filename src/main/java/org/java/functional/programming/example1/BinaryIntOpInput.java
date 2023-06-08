package org.java.functional.programming.example1;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class BinaryIntOpInput {
    private Integer a;
    private Integer b;
}
