package com.example.todo.controller;

import com.example.todo.service.TodoService;
import com.example.todo.vo.TodoVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

  @GetMapping
  public List<TodoVO> getTodos(HttpSession session) {
    Long userId = (Long) session.getAttribute("userId");
    if (userId == null) {
      throw new IllegalStateException("로그인이 필요합니다.");
    }

    return todoService.getTodosByUser(userId);
  }

  @GetMapping("/detail/{id}")
  public TodoVO getTodo(@PathVariable Long id) {
    return todoService.getTodoById(id);
  }

  @PostMapping
  public ResponseEntity<TodoVO> createTodo(@RequestBody TodoVO todo, HttpSession session) {
    Long userId = (Long) session.getAttribute("userId");
    if (userId == null) {
      throw new IllegalStateException("로그인이 필요합니다.");
    }

    todo.setUserId(userId);
    todoService.createTodo(todo);

    return ResponseEntity.ok(todo);
  }


  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateTodo(
      @PathVariable Long id,
      @RequestParam(required = false) String title,
      @RequestParam(required = false) Boolean done
  ) {
    todoService.updateTodo(id, title, done);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
  }
}
