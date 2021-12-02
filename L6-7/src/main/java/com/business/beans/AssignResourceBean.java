package com.business.beans;

import com.business.repository.ResourcesRepository;
import com.business.service.AvailabilityService;
import com.business.service.ResourceAssignmentService;
import com.business.util.ResourceType;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class AssignResourceBean {
    private int examId;
    private boolean neededProjector;
    private boolean neededRoom;
    private boolean neededLaptop;
    private boolean neededHdmiCable;
    private String result;

    @EJB
    ResourceAssignmentService resourceAssignmentService;

    public void tryToAssignResources(){
        List<ResourceType> resourceTypes = new ArrayList<>();

        if(neededProjector){
            resourceTypes.add(ResourceType.VIDEO_PROJECTOR);
        }
        if(neededRoom){
            resourceTypes.add(ResourceType.ROOM);
        }
        if(neededLaptop){
            resourceTypes.add(ResourceType.LAPTOP);
        }
        if(neededHdmiCable){
            resourceTypes.add(ResourceType.HDMI_CABLE);
        }

        boolean approved = false;
        try {
            approved = resourceAssignmentService.assignResourcesToExam(examId, resourceTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = approved ? "Succes" : "Failed: Some Resources are unavailable";
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public boolean isNeededProjector() {
        return neededProjector;
    }

    public void setNeededProjector(boolean neededProjector) {
        this.neededProjector = neededProjector;
    }

    public boolean isNeededRoom() {
        return neededRoom;
    }

    public void setNeededRoom(boolean neededRoom) {
        this.neededRoom = neededRoom;
    }

    public boolean isNeededLaptop() {
        return neededLaptop;
    }

    public void setNeededLaptop(boolean neededLaptop) {
        this.neededLaptop = neededLaptop;
    }

    public boolean isNeededHdmiCable() {
        return neededHdmiCable;
    }

    public void setNeededHdmiCable(boolean neededHdmiCable) {
        this.neededHdmiCable = neededHdmiCable;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
