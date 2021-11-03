package com.example.demo;

import com.example.demo.persistance.Plain;
import com.example.demo.repository.PlainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@SpringBootTest
public class PlainRepositoryTest extends TestConfig {

    @Autowired
    private PlainRepository plainTestRepository;

    @Test
    public void testGetAllPlains() {
        List<Plain> lists = plainTestRepository.findAll();
        assertEquals(lists.size(), 2, "Plain list size is empty");
    }

    @Test
    public void testFindBy() {
        Plain plainById = plainTestRepository.findOneById(TEST_PLAIN_ID);
        assertTrue(plainById != null, "Plain item isn't found by id");

        Plain plainByName = plainTestRepository.findOneByName(TEST_PLAIN_NAME);
        assertTrue(plainByName != null, "Plain item isn't found by name");
    }

    @Test(dependsOnMethods = {"testFindBy", "testGetAllPlains"})
    public void testDeletePlain() {
        List<Plain> lists = plainTestRepository.findAll();
        int listSize = lists.size();
        assertTrue(lists.get(TEST_PLAIN_ID) != null, "Plain item doesn't exist");

        plainTestRepository.delete(TEST_PLAIN_ID);
        lists = plainTestRepository.findAll();
        assertEquals(lists.size(), listSize - 1, "Wrong size list");
    }
}

