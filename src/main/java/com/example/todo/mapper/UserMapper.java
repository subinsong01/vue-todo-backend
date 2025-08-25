package com.example.todo.mapper;

import com.example.todo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  UserVO findByUsername(@Param("username") String username);
}
