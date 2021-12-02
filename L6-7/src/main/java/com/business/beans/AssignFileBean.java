package com.business.beans;

import com.business.repository.FileRepository;
import com.business.repository.SessionRole;
import com.business.util.RoleType;
import org.primefaces.model.file.UploadedFile;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class AssignFileBean {

    @EJB
    FileRepository fileRepository;

    @Inject
    SessionRole sessionRole;

    private UploadedFile uploadedFile;
    private int examId;
    private String result;

    public void addFile(){
        if(sessionRole.getRoleType() == RoleType.PROFESSOR) {
            fileRepository.assignFileToExam(examId, uploadedFile);
            result = "Success";
        }else{
            result = "Unauthorised";
        }

    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
