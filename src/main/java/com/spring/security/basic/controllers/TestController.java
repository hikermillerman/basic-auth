package com.spring.security.basic.controllers;

import com.spring.security.basic.models.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class TestController {

    @PostMapping(path = "employees")
    public ResponseEntity<?> greeting(@RequestBody Employee employee) {
        return ResponseEntity.ok(employee);
    }
}
