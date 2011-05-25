package com.enigmacurry.hr.service.json.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JSONServiceEntityNotFoundException extends WebApplicationException {
    public JSONServiceEntityNotFoundException(String message) {
        super(Response.status(400)
            .entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}
