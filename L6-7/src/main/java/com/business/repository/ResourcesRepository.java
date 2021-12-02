package com.business.repository;

import com.business.util.ResourceType;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
@Startup
public class ResourcesRepository {
    private Map<Integer, List<ResourceType>> resorces; // examId -> list of allocated resources
    private Map<ResourceType, Integer> availableResources;

    @PostConstruct
    public void init(){
        resorces = new HashMap<Integer, List<ResourceType>>();
        availableResources = new HashMap<>();

        availableResources.put(ResourceType.ROOM, 5);
        availableResources.put(ResourceType.LAPTOP, 3);
        availableResources.put(ResourceType.VIDEO_PROJECTOR, 2);
        availableResources.put(ResourceType.HDMI_CABLE, 1);
    }

    public int getResourceNumber(ResourceType resourceType){
        return availableResources.get(resourceType);
    }

    public void assignResourceToExam(int examId, ResourceType resourceType){
        if(this.resorces.get(examId) == null){
            List<ResourceType> resourceList = new ArrayList<>();
            resourceList.add(resourceType);
            this.resorces.put(examId, new ArrayList<ResourceType>(resourceList));
        }else{
            List<ResourceType> resourceList = this.resorces.get(examId);
            resourceList.add(resourceType);
            this.resorces.put(examId, resourceList);
        }
        availableResources.put(resourceType, availableResources.get(resourceType) - 1);
    }

    public List<ResourceType> getResourcesOfExam(int examId){
        if(resorces.get(examId) == null){
            return new ArrayList<>();
        }
        return resorces.get(examId);
    }

    public void assignResourceToExam(int examId, List<ResourceType> resourceList){
        for(ResourceType resourceType: resourceList){
            this.assignResourceToExam(examId, resourceType);
        }
    }
}
