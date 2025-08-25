package com.example.todo.controller;

import com.example.todo.service.SubTaskService;
import com.example.todo.vo.SubTaskVO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subtasks")
@RequiredArgsConstructor
public class SubTaskController {

  private final SubTaskService subTaskService;

  // 특정 Todo의 SubTask 목록 조회
  @GetMapping("/todo/{todoId}")
  public List<SubTaskVO> getSubTasksByTodoId(@PathVariable Long todoId) {
    return subTaskService.getSubTasksByTodoId(todoId);
  }

  // SubTask 생성
  @PostMapping
  public ResponseEntity<SubTaskVO> createSubTask(@RequestBody SubTaskVO subTask) {
    subTaskService.createSubTask(subTask);
    return ResponseEntity.status(201).body(subTask);
  }

  // SubTask 수정
  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateSubTask(
      @PathVariable Long id,
      @RequestParam(required = false) String content,
      @RequestParam(required = false) Boolean done
  ) {
    subTaskService.updateSubTask(id, content, done);
    return ResponseEntity.ok().build();
  }

  // SubTask 삭제
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSubTask(@PathVariable Long id) {
    subTaskService.deleteSubTask(id);
    return ResponseEntity.ok().build();
  }
}