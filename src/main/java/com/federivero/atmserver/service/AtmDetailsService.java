package com.federivero.atmserver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.federivero.atmserver.entity.Atm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class AtmDetailsService {

    private AtmDetailsService() throws IOException, JSONException{
        this.AtmList = getAtmFromJSON();
    }

    private List<Atm> AtmList;

    private List<Atm> getAtmFromJSON() throws IOException, JSONException {
        String url = "https://www.dropbox.com/s/6fg0k2wxwrheyqk/ATMs?dl=1";
        Gson gson = new Gson();
        BufferedReader br = null;
        InputStream is = new URL(url).openStream();

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            Type listAtmType = new TypeToken<List<Atm>>() {}.getType();
            List<Atm> atmList = gson.fromJson(rd, listAtmType);

            return atmList;

        } finally {
            is.close();
        }
    }
    public List<Atm> getAtmList(){
        return this.AtmList;
    }

    public List<Atm> filterAtmList(String text, List<String> fields){
        List<Atm> AtmList = new ArrayList<>();

        for(Atm atm : this.AtmList) {
            if (fields.contains("street")){
                if(atm.address.street!=null && atm.address.street.equals(text)){
                    AtmList.add(atm);
                    continue;
                }
            }
            if (fields.contains("housenumber")){
                if(atm.address.housenumber!=null && atm.address.housenumber.equals(text)){
                    AtmList.add(atm);
                    continue;
                }
            }
            if (fields.contains("postalcode")){
                if(atm.address.postalcode!=null && atm.address.postalcode.equals(text)){
                    AtmList.add(atm);
                    continue;
                }
            }
            if (fields.contains("city")){
                if(atm.address.city!=null && atm.address.city.equals(text)){
                    AtmList.add(atm);
                    continue;
                }
            }
            if (fields.contains("lat")){
                if(atm.address.geoLocation.lat!=null && atm.address.geoLocation.lat.equals(text)){
                    AtmList.add(atm);
                    continue;
                }
            }
            if (fields.contains("lng")){
                if(atm.address.geoLocation.lng!=null && atm.address.geoLocation.lng.equals(text)){
                    AtmList.add(atm);
                    continue;
                }
            }
            if (fields.contains("distance")){
                if(atm.distance!=null && atm.distance.toString().equals(text)){
                    AtmList.add(atm);
                    continue;
                }
            }
            if (fields.contains("type")){
                if(atm.type!=null && atm.type.equals(text)){
                    AtmList.add(atm);
                    continue;
                }
            }
        }

        return AtmList;
    }
}
