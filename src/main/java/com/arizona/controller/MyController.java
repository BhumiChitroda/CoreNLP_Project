package com.arizona.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arizona.model.CoreNLP;

/**
 * Handles requests for the Employee service.
 */
@CrossOrigin
@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, CoreNLP> empData = new HashMap<Integer, CoreNLP>();
    @CrossOrigin
	@RequestMapping(value = "/getnouns", method = RequestMethod.GET)
	@ResponseBody
	public List<Object> getDummyEmployee(@RequestParam("uid") String txt) {
    	System.out.println(txt);
		CoreNLP n = new CoreNLP(txt);
		System.out.println(n.getAllData());
	    return Arrays.asList(
	            n.numberofwords(),
	            n.numberofsentences(),
	            n.numberofnouns(),
	            n.getwords(),
	            n.getsentences(),
	            n.getnouns(),
	            txt,
	            n.numberofadjectives(),
	            n.getadjectives());
	}
    @RequestMapping("/new")
    @ResponseBody
    public String postResponseController() {
        return new String("Thanks For Posting!!!");
     }
	
	
}
