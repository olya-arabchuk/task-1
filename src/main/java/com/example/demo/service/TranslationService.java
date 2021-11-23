package com.example.demo.service;

import org.springframework.stereotype.Service;

import static com.example.demo.tools.Translator.toLocale;

@Service
public class TranslationService {

    public String translate() {
        return toLocale(TranslatorCode.GREETINGS.translatorCode);
    }

    enum TranslatorCode {
        GREETINGS("greetings");
        private String translatorCode;

        TranslatorCode(String code) {
            this.translatorCode = code;
        }

        public String getCode() {
            return translatorCode;
        }
    }
}
