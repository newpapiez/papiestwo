package org.example.tmp3;

public interface TokenService {

    String generateToken(UserDomain user);

    UserPrincipal parseToken(String token);
}
