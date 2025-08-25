package com.example.todo.mapper;

import com.example.todo.vo.TodoVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TodoMapper {

  //모든 todo조회
  List<TodoVO> findByUserId(Long userId);
  void insertTodo(TodoVO todo);
  void updateTodo(@Param("id") Long id, @Param("title") String title, @Param("done") boolean done);
  void deleteTodo(Long id);

  // 단건 조회
  TodoVO findById(Long id);
}
