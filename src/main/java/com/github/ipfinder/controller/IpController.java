package com.github.ipfinder.controller;

import com.github.ipfinder.model.dto.IpDto;
import com.github.ipfinder.service.IpService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/ip")
public class IpController {
    IpService ipService = new IpService();

    @GET
    @Path("/info/{ip}")
    @Produces(MediaType.APPLICATION_JSON)
    public IpDto getInfo(@PathParam("ip") String ip) {
        return ipService.getInfo(ip);
    }

    @GET
    @Path("/info/pais/{ip}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPais(@PathParam("ip") String ip) {
        return ipService.getInfo(ip).country;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello 2 from Quarkus REST";
    }
}
