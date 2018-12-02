package com.seudev.anyaddress.app.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.seudev.overjax.annotation.Controller;
import com.seudev.overjax.annotation.WrapResponse;
import com.seudev.overjax.core.builder.MessageBuilder;
import com.seudev.overjax.core.model.message.Message;

@Controller
@Path("/")
@WrapResponse
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class IndexController {

    @Inject
    private MessageBuilder messageBuilder;

    @GET
    public Response index() {
        Message message = messageBuilder.fromCode("index", false);
        return Response.ok(message).build();
    }
    
}
