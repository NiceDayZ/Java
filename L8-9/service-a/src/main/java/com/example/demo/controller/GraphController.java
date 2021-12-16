package com.example.demo.controller;

import com.example.demo.dtos.GetDocumentDTO;
import com.example.demo.dtos.GraphCyclic;
import com.example.demo.dtos.GraphDTO;
import com.example.demo.graph.Graph;
import com.example.demo.repository.DocumentRepository;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
@OpenAPIDefinition(info = @Info(title = "Booking endpoint", version = "1.0"))
@Path("/graph")
public class GraphController {
    @Inject
    DocumentRepository documentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Get All the documents",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    ref = "Graph"))
            ),
    })
    public Response graph(){
        Graph graph = new Graph(documentRepository.findAll().stream().map((GetDocumentDTO::new)).collect(Collectors.toList()));
        return Response.ok(new GraphDTO(graph)).build();
    }

    @GET
    @Path("/cyclic")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Get All the documents",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    ref = "Graph"))
            ),
    })
    public Response cycle(){
        Graph graph = new Graph(documentRepository.findAll().stream().map((GetDocumentDTO::new)).collect(Collectors.toList()));
        return Response.ok(new GraphCyclic(graph)).build();
    }
}
