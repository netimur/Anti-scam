package com.example.antiscam.databases;
import com.example.antiscam.daos.common.AbstractScammerDao;
import com.example.antiscam.daos.implementation.mssql.ScammerDaoMsSQLImpl;

import java.sql.Connection;

public class MsSqlDatabaseImpl extends AbstractDatabase {

    private AbstractScammerDao scammerDao;

    public MsSqlDatabaseImpl(Connection connection) {
        super(connection);
        this.scammerDao = new ScammerDaoMsSQLImpl(connection);

    }

    public AbstractScammerDao getScammerDao() {
        return scammerDao;
    }

}
