package com.example.antiscam.daos.common;

import java.sql.Connection;

abstract public class AbstractDao {
    protected Connection connection;
    public AbstractDao(Connection connection) {
        this.connection = connection;
    }
}
