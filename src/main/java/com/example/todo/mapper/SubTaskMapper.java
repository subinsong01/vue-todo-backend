package com.example.todo.mapper;

import com.example.todo.vo.SubTaskVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubTaskMapper {

  // 특정 Todo의 SubTask 목록 조회
  List<SubTaskVO> findByTodoId(Long todoId);
  // SubTask 생성
  void insertSubTask(SubTaskVO subTask);

  // SubTask 수정
  void updateSubTask(@Param("id") Long id, @Param("content") String content, @Param("done") Boolean done);

  // SubTask 삭제
  void deleteSubTask(Long id);
}