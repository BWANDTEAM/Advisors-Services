
package org.hackathon.packapp.containerbank.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.hackathon.packapp.containerbank.model.Advisors;
import org.hackathon.packapp.containerbank.service.BankService;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Wavestone
 */
@Controller
public class AdvisorController {

    private final BankService bankService;


    @Autowired
    public AdvisorController(BankService bankService) {
        this.bankService = bankService;
    }

//    @RequestMapping(value = { "/advisors.html"})
//    public String showAdvisorList(Map<String, Object> model) {
//        // Here we are returning an object of type 'Advisors' rather than a collection of Advisor objects
//        // so it is simpler for Object-Xml mapping
//        Advisors advisors = new Advisors();
//        advisors.getAdvisorList().addAll(this.bankService.findAdvisors());
//        model.put("advisors", advisors);
//        return "advisors/advisorList";
//    }
    
//    @RequestMapping("/showAdvisorList")
//    public
//    @ResponseBody String showAdvisorList(Map<String, Object> model) throws JsonProcessingException {
//        // Here we are returning an object of type 'Advisors' rather than a collection of Advisor objects
//        // so it is simpler for Object-Xml mapping
//        Advisors advisors = new Advisors();
//        advisors.getAdvisorList().addAll(this.bankService.findAdvisors());
////        model.put("advisors", advisors);
////        return "advisors/advisorList";
////        return advisors;c
//        
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(advisors);
//    }

//    @RequestMapping(value = { "/advisors.json", "/advisors.xml"})
//    public
//    @ResponseBody
//    Advisors showResourcesAdvisorList() {
//        // Here we are returning an object of type 'Advisors' rather than a collection of Advisor objects
//        // so it is simpler for JSon/Object mapping
//        Advisors advisors = new Advisors();
//        advisors.getAdvisorList().addAll(this.bankService.findAdvisors());
//        return advisors;
//    }
    
    
    @RequestMapping("/advisors")
    public
    @ResponseBody
    String showResourcesAdvisorList() throws JsonProcessingException {
        // Here we are returning an object of type 'Advisors' rather than a collection of Advisor objects
        // so it is simpler for JSon/Object mapping
        Advisors advisors = new Advisors();
        advisors.getAdvisorList().addAll(this.bankService.findAdvisors());
//        JSONParser test = new JSONParser();
//        test.
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(advisors);
//        return advisors;
    }


}
