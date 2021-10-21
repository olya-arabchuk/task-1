package com.example.demo.repository;

import com.example.demo.persistance.Plain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

public interface PlainRepository {

    RowMapper<Plain> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new Plain(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("type"),
                resultSet.getString("route"),
                resultSet.getInt("year"));
    };

    List<Plain> findAll();

    Plain findOneById(int id);

    Plain findOneByName(String name);

    int delete(int id);
}

