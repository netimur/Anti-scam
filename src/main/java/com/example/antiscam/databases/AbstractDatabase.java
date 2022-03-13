package com.example.antiscam.databases;

import java.sql.Connection;

abstract public class AbstractDatabase {
    protected Connection connection;

    public AbstractDatabase(Connection connection) {
        this.connection = connection;
    }
}
