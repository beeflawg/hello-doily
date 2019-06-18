package com.example.demo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataController {
	
	ListManager manager;
	
    @GetMapping()
    public List<String> getJSONItems(){
    	List<String> foundItems = manager.getItems();
    	return  foundItems;
    }
    
    @GetMapping("{name}")
	public String sayHello(@PathVariable String name) {
		return "Hello " + name + " your name has been added";
	}
    
    @PostMapping("{name")
    public ResponseEntity <String> postItem(@PathVariable String name){
    	manager.addItem(name);
    	return ResponseEntity.ok(name);
    
    }

}
