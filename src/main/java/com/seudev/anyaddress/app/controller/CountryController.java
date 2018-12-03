package com.seudev.anyaddress.app.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.seudev.anyaddress.model.Country;
import com.seudev.anyaddress.query.filter.CountryFilter;
import com.seudev.anyaddress.service.CountryService;
import com.seudev.overjax.annotation.Authenticated;
import com.seudev.overjax.annotation.Authorize;
import com.seudev.overjax.annotation.Controller;
import com.seudev.overjax.annotation.WrapResponse;

@Controller
@WrapResponse
@Authenticated
@Path("/api/v1/country")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class CountryController {

    @Context
    private UriInfo uriInfo;

    @EJB
    private CountryService countryService;

    @GET
    @Path("{id}")
    @Authorize("$.hasRole('GET_COUNTRY')")
    public Response find(UUID id) {
        Country country = countryService.findByID(id);
        return Response.status(country == null ? NOT_FOUND : OK).build();
    }

    @GET
    public Response findAll(@BeanParam CountryFilter filter) {
        List<Country> list = countryService.findAll(filter);
        return Response.ok(list).build();
    }

    @PUT
    @Path("{id}")
    public Response merge(Country country) {
        countryService.merge(country);
        return Response.ok(country).build();
    }

    @POST
    public Response persist(Country country) {
        countryService.persist(country);

        return Response.created(uriInfo.getAbsolutePathBuilder().path(country.getId().toString()).build())
                .entity(country)
                .build();
    }

}
