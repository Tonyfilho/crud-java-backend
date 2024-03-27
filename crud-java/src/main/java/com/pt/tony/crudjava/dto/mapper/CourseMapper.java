package com.pt.tony.crudjava.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pt.tony.crudjava.dto.CourseDTO;
import com.pt.tony.crudjava.dto.LessonDTO;
import com.pt.tony.crudjava.model.Course;

@Component
public class CourseMapper {
    

    public CourseDTO toDoDTO (Course course) {
        if (course == null) {
            return null;
        }
        List<LessonDTO> lessonsDTO = course.getLessons().stream().map(lesson ->  
        new LessonDTO(lesson.getId(), 
        lesson.getName(), lesson.getYoutubeUrl())
        
        ).collect(Collectors.toList());

        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessonsDTO);
    }
}
