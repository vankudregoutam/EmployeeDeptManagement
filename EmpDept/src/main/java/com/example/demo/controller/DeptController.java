package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Dept;
import com.example.demo.respstructure.FetchAllStructure;
import com.example.demo.respstructure.ResponseStructure;
import com.example.demo.services.DeptService;

@RequestMapping("/dept")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DeptController {
	
	@Autowired
	private DeptService dservice;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Dept>> saveDept(@RequestBody Dept d) {
		return dservice.saveDept(d);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<FetchAllStructure<Dept>> fetchAll() {
		return dservice.fetchAll();
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<ResponseStructure<Dept>> findById(@PathVariable int id) {
		return dservice.findById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<ResponseStructure<Dept>> deleteById(@PathVariable int id) {
		return dservice.deleteById(id);
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<ResponseStructure<Dept>> updateById(@PathVariable int id, @RequestBody Dept d) {
		return dservice.updateById(id, d);
	}

}
