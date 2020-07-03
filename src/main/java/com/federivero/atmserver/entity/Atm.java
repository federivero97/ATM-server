package com.federivero.atmserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atm {

    public Address address;
    public Integer distance;
    public String type;

}