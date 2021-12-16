package com.example.demo.repository;

import com.example.demo.entity.Document;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class DocumentRepository {

    @PersistenceContext(unitName = "default")
    protected EntityManager em;

    public DocumentRepository(){

    }

    @Transactional
    public Document save(Document document){
        if(document.getId() == null) {
            em.persist(document);
        }else{
            document = em.merge(document);
        }

        return document;
    }

    public List<Document> findAll(){
        return em.createNamedQuery("Document.findAll").getResultList();
    }

    public Document findById(Long id){
        try{
            return em.find(Document.class, id);
        }catch(Exception e){
            return null;
        }
    }

    @Transactional
    public boolean delete(Long id){
        try{
            Document document = this.findById(id);
            if(document == null){
                System.out.println("document is null");
                return false;
            }
            em.remove(document);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
