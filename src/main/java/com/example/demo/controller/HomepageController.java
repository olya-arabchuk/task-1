package com.example.demo.controller;

import com.example.demo.persistance.Plain;
import com.example.demo.service.PlainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomepageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageController.class);

    private PlainService plainService;

    public HomepageController(PlainService plainService) {
        this.plainService = plainService;
    }

    @GetMapping()
    public List<Plain>getHomepage() {
        List<Plain> plains = plainService.getAllPlains();
        LOGGER.info("Returning all data from db");
        return plains;
    }
}
