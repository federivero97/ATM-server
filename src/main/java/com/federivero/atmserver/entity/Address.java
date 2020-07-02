package com.federivero.atmserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    public String street;
    public String housenumber;
    public String postalcode;
    public String city;
    public GeoLocation geoLocation;

}