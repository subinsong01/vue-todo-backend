package com.example.todo.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubTaskRequest {
  private String content;
  private Boolean done;
}
