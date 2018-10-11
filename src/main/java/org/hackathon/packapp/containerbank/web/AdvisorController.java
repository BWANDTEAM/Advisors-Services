
package org.hackathon.packapp.containerbank.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Advisor;
import org.hackathon.packapp.containerbank.model.Advisors;
import org.hackathon.packapp.containerbank.repository.AdvisorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Wavestone
 */
@Controller
public class AdvisorController {

	private AdvisorRepository advisorRepository;


    @Autowired
    public AdvisorController(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }    
    
    @RequestMapping("/advisors")
    @CrossOrigin(origins="*")
    public
    @ResponseBody
    Advisors showResourcesAdvisorList() throws JsonProcessingException {
        // Here we are returning an object of type 'Advisors' rather than a collection of Advisor objects
        // so it is simpler for JSon/Object mapping
        Advisors advisors = new Advisors();
        advisors.getAdvisorList().addAll(this.findAdvisors());
        return advisors;
    }
    
    @Transactional(readOnly = true)
    @Cacheable(value = "advisors")
    private Collection<Advisor> findAdvisors() throws DataAccessException {
        return advisorRepository.findAll();
    }
    
}
