package org.kdh.security.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.kdh.security.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JWTUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {

        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        // ✅ 실제 로그인 검증
        if (!username.equals("user1") || !password.equals("1111")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        // ✅ 토큰 발급
        String token = jwtUtil.generateToken(username);

        return ResponseEntity.ok(Map.of("token", token));
    }

    @Data
    static class AuthRequest {
        private String username;
        private String password;
    }
}
