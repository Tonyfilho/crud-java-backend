package com.pt.tony.crudjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt.tony.crudjava.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
