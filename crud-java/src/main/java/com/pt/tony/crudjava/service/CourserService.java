package com.pt.tony.crudjava.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pt.tony.crudjava.dto.CourseDTO;
import com.pt.tony.crudjava.dto.CoursePagesDTO;
import com.pt.tony.crudjava.dto.LessonDTO;
import com.pt.tony.crudjava.dto.mapper.CourseMapper;
import com.pt.tony.crudjava.model.Course;
import com.pt.tony.crudjava.repository.CourseRepository;
import com.pt.tony.crudjava.repository.LessonRepository;

@Service
@SuppressWarnings("unused")
public class CourserService {
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;

    public CourserService(CourseRepository courseRepository, LessonRepository lessonRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.courseMapper = courseMapper;
    }

    public CoursePagesDTO list(int page, int pageSize) {
         /** Recebendo todas as paginas, o ORM (Hibernate) ja faz isto a paginação */
        Page<Course> pageCourse = this.courseRepository.findAll(PageRequest.of(page, pageSize));
       List<CourseDTO> courseDTO = pageCourse.get().map(courseMapper:: toDoDTO).toList(); /**Ou */
       List<CourseDTO> courseDTO2 = pageCourse.get().map(course -> new CourseMapper().toDoDTO(course)).collect(Collectors.toList()); /**Ou */
       List<CourseDTO> courseDTO3 = pageCourse.get().map(course -> this.courseMapper.toDoDTO(course)).toList(); /**Ou */
        
        return new CoursePagesDTO(courseDTO, (int)pageCourse.getTotalElements(), pageCourse.getTotalPages());
    }

      



}
