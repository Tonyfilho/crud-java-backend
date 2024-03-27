package com.pt.tony.crudjava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt.tony.crudjava.dto.CoursePagesDTO;
import com.pt.tony.crudjava.service.CourserService;


@RestController
@RequestMapping("/api/courses")
@SuppressWarnings("unused")
public class CourseController {
    private CourserService courserService;
    

    public CourseController(CourserService courserService) {
        this.courserService = courserService;
    }


    /**Get All with paginator */

    @GetMapping()
    public CoursePagesDTO listWithPaginator(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int pageSize) {
        return this.courserService.list(page, pageSize);
    }
    
    
}
