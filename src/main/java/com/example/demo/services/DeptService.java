package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DeptDAO;
import com.example.demo.dao.EmpDAO;
import com.example.demo.entity.Dept;
import com.example.demo.entity.Employee;
import com.example.demo.jparepo.DeptJPA;
import com.example.demo.jparepo.EmpJPA;
import com.example.demo.respstructure.FetchAllStructure;
import com.example.demo.respstructure.ResponseStructure;

@Service
public class DeptService {

	@Autowired
	private DeptDAO ddao;

	@Autowired
	private DeptJPA djpa;
	
	@Autowired
	private EmpDAO edao;
	
	@Autowired
	private EmpJPA ejpa;

//	@ExceptionHandler(DeptAlreadyExists.class)
	public ResponseEntity<ResponseStructure<Dept>> saveDept(Dept d) {
		boolean flag = djpa.existsByName(d.getName());
		ResponseStructure<Dept> res = new ResponseStructure<>();
		if(flag) {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Department name " + d.getName() + " already exists");
			res.setStatusCode(HttpStatus.BAD_GATEWAY.value());
			return new ResponseEntity<ResponseStructure<Dept>>(res, HttpStatus.BAD_GATEWAY);
		} else {
			Dept dept = ddao.saveDept(d);
			if(dept!=null) {
				res.setData(d);
				res.setDate(LocalDateTime.now());
				res.setMessage("Data entered successfully");
				res.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Dept>>(res, HttpStatus.OK);
			} else {
				res.setData(null);
				res.setDate(LocalDateTime.now());
				res.setMessage("Something went wrong");
				res.setStatusCode(HttpStatus.BAD_REQUEST.value());
				return new ResponseEntity<ResponseStructure<Dept>>(res, HttpStatus.BAD_REQUEST);
			}
		}
	}
	
	public ResponseEntity<FetchAllStructure<Dept>> fetchAll() {
		List<Dept> li = ddao.fetchAll();
		FetchAllStructure<Dept> res = new FetchAllStructure<>();
		if(li!=null) {
			res.setData(li);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data fetched successfully");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<FetchAllStructure<Dept>>(res, HttpStatus.OK);
		} else {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Table is empty");
			res.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<FetchAllStructure<Dept>>(res, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Dept>> findById(int id) {
		Dept d = ddao.findById(id);
		ResponseStructure<Dept> res = new ResponseStructure<>();
		if(d!=null) {
			res.setData(d);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data Fetched Successfully");
			res.setStatusCode(HttpStatus.OK.value());
			ResponseEntity<ResponseStructure<Dept>> re = new ResponseEntity<ResponseStructure<Dept>>(res, HttpStatus.OK);
			return re;
		} else {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Data Not Found");
			res.setStatusCode(HttpStatus.NOT_FOUND.value());
			ResponseEntity<ResponseStructure<Dept>> re = new ResponseEntity<ResponseStructure<Dept>>(res, HttpStatus.NOT_FOUND);
			return re;
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Dept>> deleteById(int id) {
		Dept d = ddao.findById(id);
		List<Employee> li = edao.findByDeptNo(id);
		ResponseStructure<Dept> res = new ResponseStructure<>();
		if(d!=null) {
			for(Employee e: li) {
				e.setDeptno(null);
				ejpa.save(e);
			}
			ddao.deleteById(id);
			res.setData(d);
			res.setDate(LocalDateTime.now());
			res.setMessage("Record deleted successfully");
			res.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Dept>>(res, HttpStatus.OK);
		} else {
			res.setData(null);
			res.setDate(LocalDateTime.now());
			res.setMessage("Record not exists");
			res.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Dept>>(res, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Dept>> updateById(int id, Dept d) {
	    ResponseStructure<Dept> res = new ResponseStructure<>();

	    Dept dept = ddao.findById(id);
	    if (dept == null) {
	        res.setData(null);
	        res.setDate(LocalDateTime.now());
	        res.setMessage("Department not found with id: " + id);
	        res.setStatusCode(HttpStatus.NOT_FOUND.value());
	        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	    }

	    boolean duplicateExists = djpa.existsByName(d.getName());
	    if (duplicateExists && !dept.getName().equalsIgnoreCase(d.getName())) {
	        res.setData(null);
	        res.setDate(LocalDateTime.now());
	        res.setMessage("Department name '" + d.getName() + "' already exists");
	        res.setStatusCode(HttpStatus.CONFLICT.value());
	        return new ResponseEntity<>(res, HttpStatus.CONFLICT);
	    }

	    if (d.getName() != null && !d.getName().isBlank()) {
	        dept.setName(d.getName());
	    }
	    if (d.getLoc() != null && !d.getLoc().isBlank()) {
	        dept.setLoc(d.getLoc());
	    }

	    Dept updated = ddao.updateById(dept);

	    res.setData(updated);
	    res.setDate(LocalDateTime.now());
	    res.setMessage("Record successfully updated");
	    res.setStatusCode(HttpStatus.OK.value());

	    return new ResponseEntity<>(res, HttpStatus.OK);
	}


}
