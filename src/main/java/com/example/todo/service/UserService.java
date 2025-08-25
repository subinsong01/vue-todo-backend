package com.example.todo.service;

import com.example.todo.dto.request.UserRequest;
import com.example.todo.mapper.UserMapper;
import com.example.todo.vo.UserVO;
import com.example.todo.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserMapper userMapper;

  public UserResponse user(UserRequest req) {
    UserVO u = userMapper.findByUsername(req.getUsername());
    if (u == null) throw new IllegalArgumentException("존재하지 않는 아이디입니다.");
    if (!u.getPassword().equals(req.getPassword())) {
      throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }
    return new UserResponse (u.getId(), u.getUsername(), u.getPassword());
  }
}
