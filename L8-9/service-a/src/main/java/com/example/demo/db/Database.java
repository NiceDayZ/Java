package com.example.demo.db;

import com.example.demo.repository.DocumentRepository;
import com.github.javafaker.Faker;
import com.example.demo.entity.Document;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Singleton
@Startup
public class Database {

    @Inject
    DocumentRepository documentRepository;

    Faker faker = new Faker();
    Random random = new Random();

    @PostConstruct
    public void start(){
        //Generate random documents
        for(int i=0; i<100; i++){
            Document document = new Document();
            document.setAuthor(faker.book().author());
            document.setTitle(faker.book().title());

            if(i > 10) {
                int numberOfReferences = random.nextInt(6);
                Set<Document> documentSet = new HashSet<>();
                for (int j = 0; j < numberOfReferences; j++) {
                    documentSet.add(getRandomDocument());
                }
                document.setBibliography(documentSet);
            }else{
                document.setBibliography(new HashSet<>());
            }

            documentRepository.save(document);
        }
    }

    private Document getRandomDocument(){
        List<Document> documentList = documentRepository.findAll();
        int index = random.nextInt(documentList.size());
        return documentList.get(index);
    }
}
