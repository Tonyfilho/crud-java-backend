package com.pt.tony.crudjava.dto;

import java.util.List;

public record PaginatorDTO(List<CourseDTO> courses, int totalElements, int totalPages ) {
    
}
