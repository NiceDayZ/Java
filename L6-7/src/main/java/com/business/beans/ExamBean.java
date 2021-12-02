package com.business.beans;

import com.business.model.Exam;
import com.business.repository.FileRepository;
import com.business.repository.ResourcesRepository;
import com.business.service.ExamService;
import com.business.util.ResourceType;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ExamBean implements Serializable {

    @Inject
    ExamService examService;

    @EJB
    ResourcesRepository resourcesRepository;

    @EJB
    FileRepository fileRepository;

    public List<Exam> getExams(){
        return examService.getExams();
    }
    public List<String> getResources(int examId){
        List<String> resources = new ArrayList<>();
        List<ResourceType> resourceTypes = resourcesRepository.getResourcesOfExam(examId);

        for(ResourceType resourceType: resourceTypes){
            resources.add(resourceType.getName());
        }

        return resources;
    }

    public StreamedContent getFile(int examId){
        try {
            return new DefaultStreamedContent(fileRepository.getFileOfExam(examId).getInputStream(), "application/pdf", "file.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
