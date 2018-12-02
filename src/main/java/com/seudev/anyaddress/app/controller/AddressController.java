package com.seudev.anyaddress.app.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.seudev.anyaddress.model.Address;
import com.seudev.anyaddress.service.AddressService;
import com.seudev.overjax.annotation.Controller;
import com.seudev.overjax.annotation.WrapResponse;

@Controller
@WrapResponse
@Path("/api/v1/address")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AddressController {
    
    @EJB
    private AddressService addressService;

    @GET
    public List<Address> findAll() {
        return addressService.findAll();
    }
    
}
