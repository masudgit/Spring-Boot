/* Copyright © 2017 Oracle and/or its affiliates. All rights reserved. */

package com.example.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeDAO edao = new EmployeeListDAO();

    // Get all employees
    @RequestMapping(method = RequestMethod.GET)
    public Employee[] getAll() {
        return edao.getAllEmployees().toArray(new Employee[0]);
    }

    // Get an employee
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity get(@PathVariable long id) {

        Employee match = null;
        match = edao.getEmployee(id);
        
        if (match != null) {
            return new ResponseEntity<>(match, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get employees by lastName (Week 2)
    @RequestMapping(method = RequestMethod.GET, value = "/lastname/{name}")
    public ResponseEntity getByLastName(@PathVariable String name) {
    	
    	List<Employee> matchList = edao.getByLastName(name);
    	if(matchList.size() > 0){
    		return new ResponseEntity<>(matchList, HttpStatus.OK);
    	}else{
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	}
    } 

    // Get employee by title (Week 2)
    @RequestMapping(method = RequestMethod.GET, value= "/title/{name}")
    public ResponseEntity getByTitle(@PathVariable String name){
    	
    	List<Employee> matchList = edao.getByTitle(name);
    	if(matchList.size() > 0){
    		return new ResponseEntity<>(matchList, HttpStatus.OK);
    	}else{
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	}
    }

    // Get employee by dept (Week 2)
    @RequestMapping(method = RequestMethod.GET, value= "/department/{name}")
    public ResponseEntity getByDept(@PathVariable String name){
    	
    	List<Employee> matchList = edao.getByDept(name);
    	if(matchList.size() > 0){
    		return new ResponseEntity<>(matchList, HttpStatus.OK);
    	}else{
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	}
    }
    
    // Add an employee
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody Employee employee) {
        if (edao.add(employee)) {
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an employee
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody Employee employee) {

        if (edao.update(id, employee)) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete a employee (Week 3)
    @RequestMapping(method = RequestMethod.DELETE, value= "{id}")
    public ResponseEntity delete(@PathVariable long id){
    	if( edao.delete(id) ){
    		return new ResponseEntity<>(null, HttpStatus.OK);
    	}else{
    		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    	}
    }
    

}
