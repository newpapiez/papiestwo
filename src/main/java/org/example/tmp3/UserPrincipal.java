package org.example.tmp3;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserPrincipal {

    private final Long id;

    private final String username;
}
