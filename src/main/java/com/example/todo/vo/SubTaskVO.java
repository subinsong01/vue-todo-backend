package com.example.todo.vo;

import lombok.Data;

@Data
public class SubTaskVO {
  private Long id;
  private Long todoId;
  private String content;
  private Boolean done;
}
