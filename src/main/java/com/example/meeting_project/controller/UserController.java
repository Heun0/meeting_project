package com.example.meeting_project.controller;


import com.example.meeting_project.dto.UserRequestDTO;
import com.example.meeting_project.dto.UserResponseDTO;
import com.example.meeting_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequestDTO userRequestDTO){
        String message = userService.register(userRequestDTO.getEmail(), userRequestDTO.getPassword());
        return ResponseEntity.ok(message);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDTO userRequestDTO) {
        String message = userService.login(userRequestDTO.getEmail(), userRequestDTO.getPassword());
        return ResponseEntity.ok(message);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        userService.logout(token.replace("Bearer ", "")); // "Bearer " 부분 제거
        return ResponseEntity.ok("로그아웃 성공");
    }



}
