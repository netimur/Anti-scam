package com.example.antiscam.controllers;


import com.example.antiscam.SafeNumberResponse;
import com.example.antiscam.databaseconnections.MsSQLConnection;
import com.example.antiscam.databases.MsSqlDatabaseImpl;
import com.example.antiscam.model.Scammer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("is_it_safe")
public class SafetyNumberController {

    private MsSqlDatabaseImpl database = new MsSqlDatabaseImpl(MsSQLConnection.getConnection());


    @GetMapping("{number}")
    SafeNumberResponse safetyNumber(@PathVariable String number) {
        ArrayList<Scammer> scammers = database.getScammerDao().read();
        SafeNumberResponse response;
        for (Scammer scammer : scammers
        ) {
            if (scammer.getNumber().equals(number)) {
                response = new SafeNumberResponse(false);
                return response;
            }
        }
        response = new SafeNumberResponse(true);
        return response;
    }

    @GetMapping("unsafe")
    ArrayList<String> getUnsafeNumbers() {
        ArrayList<Scammer> scammers = database.getScammerDao().read();
        ArrayList<String> numbers = new ArrayList<>();
        for (Scammer sc : scammers
        ) {
            numbers.add(sc.getNumber());
        }
        return numbers;
    }


}
