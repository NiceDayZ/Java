package com.example.demo.db;

import com.example.demo.dtos.GetDocumentDTO;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class CachedDocuments {
    List<GetDocumentDTO> getDocumentDTOS;

    @PostConstruct
    public void start() {
        getDocumentDTOS = new ArrayList<>();
    }

}
