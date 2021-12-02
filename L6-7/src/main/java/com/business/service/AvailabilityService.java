package com.business.service;

import com.business.repository.ResourcesRepository;
import com.business.util.ResourceType;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AvailabilityService {

    @EJB
    ResourcesRepository resourcesRepository;

    public boolean getResourceAvailability(ResourceType resourceType){
        return (resourcesRepository.getResourceNumber(resourceType) > 0);
    }
}
