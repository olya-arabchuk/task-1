package com.example.demo.service;

import com.example.demo.persistance.Plain;
import com.example.demo.repository.PlainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlainService {

    private PlainRepository plainRepository;

    public PlainService(PlainRepository plainRepository) {
        this.plainRepository = plainRepository;
    }

    public List<Plain> getAllPlains() {
        return plainRepository.findAll();
    }
}
