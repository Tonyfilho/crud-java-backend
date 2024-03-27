package com.pt.tony.crudjava.dto;

import java.util.List;

public record CoursePagesDTO(List<CourseDTO> coursesDTO, int totalElements, int totalPages ) {
    
}
