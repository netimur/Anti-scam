package com.example.antiscam.controllers;

import com.example.antiscam.databaseconnections.MsSQLConnection;
import com.example.antiscam.databases.MsSqlDatabaseImpl;
import com.example.antiscam.model.Scammer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("scammers")
public class ScammersController {

    private MsSqlDatabaseImpl database = new MsSqlDatabaseImpl(MsSQLConnection.getConnection());

    @GetMapping
    public ArrayList<Scammer> read(){
        return database.getScammerDao().read();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void create(@RequestBody Scammer scammer){
        if(scammer.getNumber()!=null && scammer.getInitLink()!=null)
            database.getScammerDao().create(scammer);
    }

}
