package com.seudev.anyaddress.query.filter;

import javax.ws.rs.QueryParam;

public class CountryFilter {
    
    @QueryParam("abbreviation")
    private String abbreviation;
    
    @QueryParam("name")
    private String name;
    
    public String getAbbreviation() {
        return abbreviation;
    }
    
    public String getName() {
        return name;
    }
    
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
