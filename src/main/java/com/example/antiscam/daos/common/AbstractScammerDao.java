package com.example.antiscam.daos.common;

import com.example.antiscam.daos.DAO;

import java.sql.Connection;

abstract public class AbstractScammerDao extends AbstractDao implements DAO.ScammerDao {
    public AbstractScammerDao(Connection connection) {
        super(connection);
    }
}
