package com.example.demo.controller;

import com.example.demo.persistance.Plain;
import com.example.demo.service.PlainService;
import com.example.demo.service.TranslationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomepageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageController.class);

    private PlainService plainService;

    private final TranslationService translationService;

    public HomepageController(PlainService plainService, TranslationService translationService) {
        this.plainService = plainService;
        this.translationService = translationService;
    }

    @GetMapping()
    public List<Plain> getHomepage() {
        List<Plain> plains = plainService.getAllPlains();
        LOGGER.info("Returning all data from db");
        return plains;
    }

    @GetMapping("/hello-translate")
    public String getTranslation() {
        String translation = translationService.translate();
        LOGGER.info("Get greetings");
        return translation;
    }

}
