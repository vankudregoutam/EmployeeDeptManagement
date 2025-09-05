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

import com.example.demo.entity.Employee;
import com.example.demo.respstructure.FetchAllStructure;
import com.example.demo.respstructure.ResponseStructure;
import com.example.demo.services.EmpService;

@RequestMapping("/emp")
@RestController
@CrossOrigin(origins = "https://employee-dept-management.vercel.app/")
public class EmpController {
	
	@Autowired
	private EmpService eservice;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmp(@RequestBody Employee e) {
		return eservice.saveEmp(e);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<FetchAllStructure<Employee>> fetchAll() {
		return eservice.fetchAll();
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findById(@PathVariable int id) {
		return eservice.findById(id);
	}
	
	@PostMapping("/findByDeptNo/{id}")
	public ResponseEntity<FetchAllStructure<Employee>> findByDeptNo(@PathVariable int id) {
		return eservice.findByDeptNo(id);
	}
	
	@PutMapping("updateById/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateById(@PathVariable int id, @RequestBody Employee emp) {
		return eservice.updateById(id, emp);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteById(@PathVariable int id) {
		return eservice.deleteById(id);
	}

}
