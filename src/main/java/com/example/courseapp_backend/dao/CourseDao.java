package com.example.courseapp_backend.dao;

import com.example.courseapp_backend.model.Courses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseDao  extends CrudRepository<Courses,Integer> {
    @Query(value = "SELECT `id`, `coursetitle`, `date`, `description`, `duration`, `venue` FROM `courses` WHERE `coursetitle`=:coursetitle",nativeQuery = true )
    List<Courses> SearchCourses(@Param("coursetitle")String coursetitle);
}
