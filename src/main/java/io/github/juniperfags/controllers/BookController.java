package io.github.juniperfags.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.github.juniperfags.services.StringService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BookController {

    private StringService stringService;

    public BookController(StringService stringService) {
        this.stringService = stringService;
    }

    @GetMapping("/public")
    public String getMethodName() {
        return stringService.getProjectName();
        // return "Spring-Hibernate";
    }

}