package org.example.tmp3;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList()); // TODO - roles
    }

    public void save(UserDomain userDomain) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDomain.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDomain.getPassword()));
        userRepository.save(userEntity);
    }

    public UserDomain login(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        boolean matches = passwordEncoder.matches(password, userEntity.getPassword());
        if (!matches) {
            throw new RuntimeException("Wrong password");
        }
        return UserDomain.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .build();
    }
}
