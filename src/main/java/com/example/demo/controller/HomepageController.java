package com.example.demo.controller;

import com.example.demo.persistance.Plain;
import com.example.demo.service.PlainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomepageController {

    @Autowired
    private PlainService plainService;

    @GetMapping()
    public ResponseEntity<List<Plain>> getHomepage() {
        List<Plain> plains = plainService.getAllPlains();
        return new ResponseEntity<>(plains, HttpStatus.OK);
    }
}
