package com.example.todo.service;

import com.example.todo.mapper.TodoMapper;
import com.example.todo.vo.TodoVO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class TodoService {

  private final TodoMapper todoMapper;

  public List<TodoVO> getTodosByUser(Long userId) {
    return todoMapper.findByUserId(userId);
  }

  public TodoVO getTodoById(Long id) {
    return todoMapper.findById(id);
  }

  public void createTodo(TodoVO todo) {
    todoMapper.insertTodo(todo);
  }

  public void updateTodo(Long id, String title, boolean done) {
    todoMapper.updateTodo(id, title, done);
  }

  public void deleteTodo(Long id) {
    todoMapper.deleteTodo(id);
  }
}
