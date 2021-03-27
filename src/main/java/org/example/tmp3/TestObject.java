package org.example.tmp3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
@ToString
public class TestObject {

    @NotNull
    private final Integer property1;

    @NotNull
    private final String property2;
}
