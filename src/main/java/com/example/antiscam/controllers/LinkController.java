package com.example.antiscam.controllers;


import com.example.antiscam.databaseconnections.MsSQLConnection;
import com.example.antiscam.databases.MsSqlDatabaseImpl;
import com.example.antiscam.model.Scammer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("link_analyzer")
public class LinkController {
    private MsSqlDatabaseImpl database = new MsSqlDatabaseImpl(MsSQLConnection.getConnection());


    @GetMapping("")
    ArrayList<String> getLinks() {
        ArrayList<String> links = new ArrayList<>();
        ArrayList<Scammer> scammers = database.getScammerDao().read();
        for (Scammer sc : scammers
        ) {
            links.add(sc.getInitLink());
        }
        return links;
    }

}
