package org.example.tmp3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.HashMap;

@Component
@Path("/user")
@Slf4j
@RequiredArgsConstructor
public class UserRestResource {

    private final UserService userService;
    private final TokenService tokenService;

    @POST
    @Path("/register")
    @Consumes("application/json")
    public void register(@Valid UserRegisterRequest request) {
        userService.save(UserDomain.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .build());
    }

    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Object login(@Valid UserLoginRequest request) {
        UserDomain userDomain = userService.login(request.getUsername(), request.getPassword());
        String token = tokenService.generateToken(userDomain);
        return new HashMap<String, String>() {{
            put("token", token);
        }};
    }

    @GET
    @Path("/tmp")
    @Produces("application/json")
    public Object tmp() {
        return new HashMap<String, String>() {{
            put("tmp", "tmp");
        }};
    }
}
