package com.example.antiscam.daos;

import com.example.antiscam.model.Scammer;

import java.util.ArrayList;

public interface DAO<T> {
    void create(T t);
    ArrayList<T> read();
    void update(T t);
    void delete(T t);

    interface ScammerDao extends DAO<Scammer> {}

}
