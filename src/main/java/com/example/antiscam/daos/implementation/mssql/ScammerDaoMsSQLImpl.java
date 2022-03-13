package com.example.antiscam.daos.implementation.mssql;

import com.example.antiscam.daos.common.AbstractScammerDao;
import com.example.antiscam.model.Scammer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class ScammerDaoMsSQLImpl extends AbstractScammerDao {


    public ScammerDaoMsSQLImpl(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Scammer scammer) {
        String scammerNumber = scammer.getNumber();
        String initLink = scammer.getInitLink();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO scammers (number, initial_link) VALUES(?,?)");
            preparedStatement.setString(1, scammerNumber);
            preparedStatement.setString(2, initLink);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Scammer> read() {
        ArrayList<Scammer> scammers = new ArrayList<>();
        try {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM scammers");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String number = resultSet.getString("number");
                String initLink = resultSet.getString("initial_link");
                Scammer scammer = new Scammer(id, number, initLink);
                scammers.add(scammer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scammers;
    }

    @Override
    public void update(Scammer scammer) {

    }

    @Override
    public void delete(Scammer scammer) {

    }
}
