package com.seudev.anyaddress.app.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.seudev.anyaddress.model.Country;
import com.seudev.anyaddress.model.State;
import com.seudev.anyaddress.service.CountryService;
import com.seudev.anyaddress.service.StateService;
import com.seudev.overjax.annotation.Controller;
import com.seudev.overjax.annotation.WrapResponse;

@Controller
@WrapResponse
@Path("/api/v1/country/{countryId}/state")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class StateController {
    
    @Context
    private UriInfo uriInfo;
    
    @EJB
    private CountryService countryService;

    @EJB
    private StateService stateService;
    
    @GET
    @Path("{id}")
    public Response find(UUID id) {
        State state = stateService.findByID(id);
        return Response.status(state == null ? NOT_FOUND : OK).build();
    }
    
    @GET
    public Response findAll(@PathParam("countryId") UUID countryId) {
        List<State> list = stateService.findAll(countryId);
        return Response.ok(list).build();
    }

    @PUT
    @Path("{id}")
    public Response merge(@PathParam("countryId") UUID countryId, State state) {
        Country country = countryService.findByID(countryId);
        state.setCountry(country);
        stateService.merge(state);
        return Response.ok(state).build();
    }

    @POST
    public Response persist(@PathParam("countryId") UUID countryId, State state) {
        Country country = countryService.findByID(countryId);
        state.setCountry(country);
        stateService.persist(state);

        return Response.created(uriInfo.getAbsolutePathBuilder().path(state.getId().toString()).build())
                .entity(state)
                .build();
    }
    
}
