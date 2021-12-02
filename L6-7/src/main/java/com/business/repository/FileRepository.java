package com.business.repository;



import org.primefaces.model.file.UploadedFile;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Startup
public class FileRepository {
    private Map<Integer, UploadedFile> uploadedFileMap;

    @PostConstruct
    public void init(){
        uploadedFileMap = new HashMap<>();
    }

    public void assignFileToExam(int examId, UploadedFile uploadedFile){
        System.out.println("CEVAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        uploadedFileMap.put(examId, uploadedFile);
        System.out.println(uploadedFileMap.get(3));
    }

    public UploadedFile getFileOfExam(int examId){
        return uploadedFileMap.get(examId);
    }
}
