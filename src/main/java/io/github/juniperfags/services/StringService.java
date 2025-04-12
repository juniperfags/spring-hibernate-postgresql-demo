package io.github.juniperfags.services;

import org.springframework.stereotype.Component;

@Component
public class StringService {

    public String getProjectName() {
        return "spring-hibernate-postgresql-demo";
    }
}