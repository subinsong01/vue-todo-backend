package com.example.todo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.todo.mapper")
public class MyBatisConfig {}
