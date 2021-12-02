package com.business.service;

import com.business.repository.ResourcesRepository;
import com.business.util.ResourceType;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.*;
import java.util.List;

@Stateful
public class ResourceAssignmentService {

    @EJB
    ResourcesRepository resourcesRepository;

    @EJB
    AvailabilityService availabilityService;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean assignResourcesToExam(int examId, List<ResourceType> resourceTypeList) throws Exception {

            for(ResourceType resourceType: resourceTypeList){
                if(!availabilityService.getResourceAvailability(resourceType)) {
                    throw new Exception("Resource not available");
                }
                resourcesRepository.assignResourceToExam(examId, resourceType);
            }

            return true;
    }

}
