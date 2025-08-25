package com.example.todo.controller;

import com.example.todo.dto.request.UserRequest;
import com.example.todo.dto.response.UserResponse;
import com.example.todo.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody UserRequest req, HttpSession session) {
    UserResponse user = userService.user(req); // 로그인 검증
    session.setAttribute("userId", user.getId()); // 세션에 userId 저장
    return ResponseEntity.ok("로그인 성공");
  }
}
