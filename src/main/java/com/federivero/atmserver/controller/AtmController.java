package com.federivero.atmserver.controller;

import com.federivero.atmserver.entity.Atm;
import com.federivero.atmserver.service.AtmDetailsService;
import org.json.JSONException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class AtmController {

    @Autowired
    private AtmDetailsService atmDetailsService;

    @GetMapping("/atm")
    public List<Atm> atm(@RequestParam(value = "q", required = false, defaultValue = "") String text, @RequestParam(value = "fields", required = false, defaultValue = "") List<String> fields) throws IOException, JSONException {

        List<Atm> atmList = new ArrayList<>();

        if (text==null || fields.isEmpty()){
            atmList = atmDetailsService.getAtmList();
        } else {
            atmList = atmDetailsService.filterAtmList(text, fields);
        }
        return atmList;
    }
}
