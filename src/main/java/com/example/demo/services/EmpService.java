package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.example.demo.dao.DeptDAO;
import com.example.demo.dao.EmpDAO;
import com.example.demo.entity.Employee;
import com.example.demo.respstructure.FetchAllStructure;
import com.example.demo.respstructure.ResponseStructure;

@Service
public class EmpService {
	
	@Autowired
	private EmpDAO edao;
	
//	@Autowired
//	private DeptDAO ddao;
	
	public ResponseEntity<ResponseStructure<Employee>> saveEmp(Employee e) {
		Employee emp = edao.saveEmp(e);
		ResponseStructure<Employee> res = new ResponseStructure<>();
		if(emp!=null) {
			res.setData(emp);
			res.setDate(LocalDateTime.now());
			res.setMessage("Record inserted Successfully");
			res.setStatusCode(HttpStatus.ACCEPTED.value());
			ResponseEntity<ResponseStructure<Employee>> re = new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.OK);
			return re;
		} else {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Something went wrong");
			res.setStatusCode(HttpStatus.BAD_REQUEST.value());
			ResponseEntity<ResponseStructure<Employee>> re = new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.BAD_REQUEST);
			return re;
		}
	}
	
	public ResponseEntity<FetchAllStructure<Employee>> fetchAll() {
		List<Employee> li = edao.fetchAll();
		FetchAllStructure<Employee> res = new FetchAllStructure<>();
		if(li!=null) {
			res.setData(li);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data fetched successfully");
			res.setStatusCode(HttpStatus.FOUND.value());
			ResponseEntity<FetchAllStructure<Employee>> re = new ResponseEntity<FetchAllStructure<Employee>>(res, HttpStatus.FOUND);
			return re;
		} else {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data not found");
			res.setStatusCode(HttpStatus.NOT_FOUND.value());
			ResponseEntity<FetchAllStructure<Employee>> re = new ResponseEntity<FetchAllStructure<Employee>>(res, HttpStatus.NOT_FOUND);
			return re;
		}
	}
	
	public ResponseEntity<FetchAllStructure<Employee>> findByDeptNo(int id) {
		List<Employee> li = edao.findByDeptNo(id);
		FetchAllStructure<Employee> res = new FetchAllStructure<>();
		if(li!=null && !li.isEmpty()) {
			res.setData(li);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data found successfully");
			res.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<FetchAllStructure<Employee>>(res, HttpStatus.FOUND);
		} else {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data not found");
			res.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<FetchAllStructure<Employee>>(res, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> updateById(int id, Employee emp) {
		Employee e = edao.findById(id);
		ResponseStructure<Employee> res = new ResponseStructure<>();
		if(e!=null) {
			Employee employee = edao.updateById(e, emp);
			res.setData(employee);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data updated successfully");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.OK);
		} else {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data not found");
			res.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Employee>> deleteById(int id) {
		Employee e = edao.findById(id);
		ResponseStructure<Employee> res = new ResponseStructure<>();
		if(e!=null) {
			edao.deleteById(id);
			res.setData(e);
			res.setDate(LocalDateTime.now());
			res.setMessage("Record deleted successfully");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.OK);
		} else {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Record not exists");
			res.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Employee>>(res, HttpStatus.NOT_FOUND);
		}
	}

}
