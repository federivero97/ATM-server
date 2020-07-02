package com.federivero.atmserver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import com.federivero.atmserver.entity.Atm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class JsonReaderService {

    public List<Atm> getAtms() throws IOException, JSONException {
        String url = "https://www.dropbox.com/s/6fg0k2wxwrheyqk/ATMs?dl=1";
        Gson gson = new Gson();
        BufferedReader br = null;
        InputStream is = new URL(url).openStream();

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            Type listAtmType = new TypeToken<List<Atm>>() {}.getType();
            List<Atm> atms = gson.fromJson(rd, listAtmType);

            return atms;

        } finally {
            is.close();
        }
    }
}
