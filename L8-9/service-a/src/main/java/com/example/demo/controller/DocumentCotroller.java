package com.example.demo.controller;

import com.example.demo.dtos.CreateDocumentDTO;
import com.example.demo.dtos.GetDocumentDTO;
import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
@OpenAPIDefinition(info = @Info(title = "Booking endpoint", version = "1.0"))
@Path("/documents")
public class DocumentCotroller {

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
                                    ref = "Document"))
            ),
    })
    public Response findAll(){
        return Response.ok(documentRepository.findAll().stream().map((GetDocumentDTO::new)).collect(Collectors.toList())).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{documentId}")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Get a document by its id",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    ref = "Document"))
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "No document found for the id.")
    })
    public Response findOne(@PathParam("documentId") Long id){
        Document document = documentRepository.findById(id);

        if(document != null){
            return Response.ok(new GetDocumentDTO(document)).build();
        }else{
            return Response.status(404).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Add a document to the database",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    ref = "Document"))
            ),
    })
    public Response create(@RequestBody CreateDocumentDTO createDocumentDTO){
        return Response.ok(
                new GetDocumentDTO(
                        documentRepository.save(
                                new Document(
                                        createDocumentDTO.getAuthor(),
                                        createDocumentDTO.getTitle(),
                                        createDocumentDTO.getReferences().stream().map(
                                                ref -> documentRepository.findById(ref)).collect(Collectors.toSet()))))).build();
    }

    @PATCH
    @Path("{documentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Add a document to the database",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    ref = "Document"))
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "No document found for the id.")
    })
    public Response update(@PathParam("documentId") Long id, @RequestBody CreateDocumentDTO createDocumentDTO){
        Document document = documentRepository.findById(id);

        if(document == null){
            return Response.status(404).build();
        }

        if(createDocumentDTO.getAuthor() != null){
            document.setAuthor(createDocumentDTO.getAuthor());
        }
        if(createDocumentDTO.getTitle() != null){
            document.setTitle(createDocumentDTO.getTitle());
        }
        if(createDocumentDTO.getReferences() != null){
            document.setBibliography(createDocumentDTO.getReferences().stream().map(
                    ref -> documentRepository.findById(ref)).collect(Collectors.toSet()));
        }

        return Response.ok(new GetDocumentDTO(documentRepository.save(document))).build();
    }

    @DELETE
    @Path("{documentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Add a document to the database",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(
                                    ref = "Document"))
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "No document found for the id.")
    })
    public Response delete(@PathParam("documentId") Long id){
        Document document = documentRepository.findById(id);

        if(document != null){
            boolean response = documentRepository.delete(id);
            System.out.println(response);
            return Response.ok().build();
        }else{
            return Response.status(404).build();
        }
    }
}
