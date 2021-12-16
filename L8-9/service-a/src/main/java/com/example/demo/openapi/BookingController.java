package com.example.demo.openapi;

import com.example.demo.dtos.CreateDocumentDTO;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/booking")
@ApplicationScoped
@OpenAPIDefinition(info = @Info(title = "Booking endpoint", version = "1.0"))
public class BookingController {

    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Booking for id",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    ref = "Booking"))
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "No booking found for the id.")
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{bookingId}")
    public Response getBooking(@PathParam("bookingId") String bookingId) {
        return Response
                .status(Response.Status.OK)
                .entity(Booking.booking(bookingId, Destination.destination("New Rearendia", "Wheeli")))
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBooking(@RequestBody CreateDocumentDTO createDocument){
        System.out.println(createDocument.toString());
        return Response
                .status(Response.Status.OK)
                .build();
    }

}
