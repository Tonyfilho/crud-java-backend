package com.pt.tony.crudjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt.tony.crudjava.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long>{
    
}
