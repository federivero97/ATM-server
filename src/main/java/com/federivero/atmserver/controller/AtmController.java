package com.federivero.atmserver.controller;

import com.federivero.atmserver.entity.Atm;
import com.federivero.atmserver.service.JsonReaderService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class AtmController {

    @Autowired
    private JsonReaderService jsonReaderService;

    @GetMapping("/atm")
    public List<Atm> atm() throws IOException, JSONException {
        List<Atm> atmList = jsonReaderService.getAtms();
        return atmList;
    }
}
