package com.example.demo;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@TestPropertySource(locations = "classpath:application-test.properties")
public class TestConfig extends AbstractTestNGSpringContextTests {

    public static final String DB_TEST_SCRIPT = "testDB.sql";
    public static final int TEST_PLAIN_ID = 1;
    public static final String TEST_PLAIN_NAME = "c320";

    public final static PostgreSQLContainer<?> POSTGRES_SQL_CONTAINER =
            new PostgreSQLContainer<>("postgres:11")
                    .withInitScript(DB_TEST_SCRIPT);

    @BeforeClass
    public void startContainer() {
        POSTGRES_SQL_CONTAINER.start();
    }

    @AfterClass
    public void stopContainer() {
        POSTGRES_SQL_CONTAINER.stop();
    }


}
