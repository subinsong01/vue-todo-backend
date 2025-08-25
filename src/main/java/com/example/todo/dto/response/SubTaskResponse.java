package com.example.todo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubTaskResponse {
  private Long id;
  private String content;
  private Boolean done;
  private Long todoId;
}
