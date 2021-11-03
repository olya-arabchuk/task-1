package com.example.demo;

import com.example.demo.persistance.Plain;
import com.example.demo.repository.PlainRepository;
import com.example.demo.repository.impl.PlainRepositoryImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@SpringBootTest
public class PlainRepositoryTest extends TestConfig {

    private PlainRepository plainTestRepository;

    @BeforeClass
    public void startContainer() {
        POSTGRES_SQL_CONTAINER.start();

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(POSTGRES_SQL_CONTAINER.getJdbcUrl());
        hikariConfig.setUsername(POSTGRES_SQL_CONTAINER.getUsername());
        hikariConfig.setPassword(POSTGRES_SQL_CONTAINER.getPassword());
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        plainTestRepository = new PlainRepositoryImpl(new JdbcTemplate(dataSource));
    }

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

