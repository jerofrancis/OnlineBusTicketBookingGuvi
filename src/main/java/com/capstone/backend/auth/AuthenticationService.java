package com.capstone.backend.auth;

import com.capstone.backend.config.JwtService;
import com.capstone.backend.user.Role;
import com.capstone.backend.user.User;
import com.capstone.backend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) throws IOException {

        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .name(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .gender(request.getGender())
                .roles(Set.of(Role.valueOf(request.getRole())))
                .build();

        repository.save(user);

        var u = repository.findByEmail(request.getEmail())
                .orElseThrow();
        Set<Role> role = u.getRoles();
        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(role)
                .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(new HashMap<>(),user);
        Set<Role> role = user.getRoles();
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(role)
                .build();
    }

}
