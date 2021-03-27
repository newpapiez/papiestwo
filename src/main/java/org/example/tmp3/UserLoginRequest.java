package org.example.tmp3;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class UserLoginRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
