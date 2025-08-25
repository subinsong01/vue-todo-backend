package com.example.todo.service;

import com.example.todo.mapper.SubTaskMapper;
import com.example.todo.vo.SubTaskVO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubTaskService {

  private final SubTaskMapper subTaskMapper;
  public List<SubTaskVO> getSubTasksByTodoId(Long todoId) {
    return subTaskMapper.findByTodoId(todoId);
  }

  // SubTask 생성
  public void createSubTask(SubTaskVO subTask) {
    subTaskMapper.insertSubTask(subTask);
  }

  // SubTask 수정
  public void updateSubTask(Long id, String content, Boolean done) {
    subTaskMapper.updateSubTask(id, content, done);
  }

  // SubTask 삭제
  public void deleteSubTask(Long id) {
    subTaskMapper.deleteSubTask(id);
  }

}