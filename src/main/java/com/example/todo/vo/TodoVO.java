package com.example.todo.vo;

import java.util.List;
import lombok.Data;

@Data
public class TodoVO {
  private Long id;
  private Long userId;
  private String title;
  private boolean done;
  private List<SubTaskVO> subTasks;
}
