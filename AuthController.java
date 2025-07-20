package com.EcommerceApplication.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.EcommerceApplication.Model.User;
import com.EcommerceApplication.Repository.UserRepository;
import com.EcommerceApplication.Util.JwtUtil;
import com.EcommerceApplication.dto.AuthRequest;
import com.EcommerceApplication.dto.AuthResponse;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager = null;
    private final JwtUtil jwtUtil = new JwtUtil();
    private final UserRepository userRepository = null;
    private final PasswordEncoder passwordEncoder = null;

    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
       
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // Authenticate user credentials
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        // Fetch user from database
        User user = ( userRepository.findByUsername(request.getUsername())).orElseThrow();

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());

        // Return token in response
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
