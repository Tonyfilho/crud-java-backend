package com.pt.tony.crudjava.dto;

import java.util.List;

import com.pt.tony.crudjava.enums.Category;
import com.pt.tony.crudjava.enums.validations.ValueOfEnum;

public record CourseDTO(Long id, String name, @ValueOfEnum(enumClass = Category.class) String category, List<LessonDTO> lessons ) {
    
}
