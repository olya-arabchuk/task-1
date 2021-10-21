package com.example.demo.repository.impl;

import com.example.demo.persistance.Plain;
import com.example.demo.repository.PlainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class PlainRepositoryImpl implements PlainRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlainRepository.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlainRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Plain> findAll() {
        return jdbcTemplate.query("select * from plains", ROW_MAPPER);
    }

    @Override
    public Plain findOneById(int id) {
        Plain plain = null;
        try {
            plain = jdbcTemplate.queryForObject("select * from plains where id = ?", ROW_MAPPER, new Object[]{id});
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Plain with id {}", id);
        }
        return plain;
    }

    @Override
    public Plain findOneByName(String name) {
        Plain plain = null;
        try {
            plain = jdbcTemplate.queryForObject("select * from plains where name = ?", ROW_MAPPER, new Object[]{name});
        } catch (DataAccessException dataAccessException) {
            LOGGER.debug("Couldn't find entity of type Plain with name {}", name);
        }
        return plain;
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from plains where id = ?", id);
    }
}

