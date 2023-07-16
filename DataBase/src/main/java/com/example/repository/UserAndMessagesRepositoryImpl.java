package com.example.repository;

import com.example.model.UsersMessage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class UserAndMessagesRepositoryImpl implements UserAndMessagesRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserAndMessagesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<UsersMessage> findAll() {
        return jdbcTemplate.query(
                "select name, message ,convertMessage   from UsersAndMessages",
                this::mapRowToIngredient);
    }

    @Override
    public int insert(UsersMessage usersMessage) {
        return jdbcTemplate.update("insert into UsersAndMessages (name, message ,convertMessage)  values ( ?,?,? ) ", usersMessage.getName(),
                usersMessage.getMessage(), usersMessage.getConvertMessage());
    }

    private UsersMessage mapRowToIngredient(ResultSet row, int rowNum)
            throws SQLException {
        return new UsersMessage(
                row.getString("name"),
                row.getString("message"),
                row.getString("convertMessage"));
    }


}
