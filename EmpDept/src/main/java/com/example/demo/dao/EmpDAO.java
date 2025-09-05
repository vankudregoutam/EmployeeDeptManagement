package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.example.demo.entity.Dept;
//import com.example.demo.entity.Dept;
import com.example.demo.entity.Employee;
//import com.example.demo.jparepo.DeptJPA;
import com.example.demo.jparepo.EmpJPA;

@Repository
public class EmpDAO {
	
	@Autowired
	private EmpJPA ejpa;
	
//	@Autowired
//	private DeptJPA djpa;
	
	public Employee saveEmp(Employee e) {
//		if(option.isPresent()) {
//			e.setDept(option.get());
//		} else {
//			e.setDept(null);
//		}
		return ejpa.save(e);
	}
	
	public List<Employee> fetchAll() {
		List<Employee> li = ejpa.findAll();
		return li;
	}
	
	public List<Employee> findByDeptNo(int id) {
		return ejpa.findByDeptno(id);
	}
	
	public Employee findById(int id) {
		Optional<Employee> option = ejpa.findById(id);
		return option.isPresent()?option.get():null;
	}
	
	public Employee updateById(Employee e, Employee emp) {
		Optional<Employee> option = ejpa.findById(e.getId());
		if(option.isPresent()) {
			if(emp.getName()!=null && !emp.getName().isEmpty()) {
				e.setName(emp.getName());
			}
			if(emp.getCom()!=null) {
				e.setCom(emp.getCom());
			}
			if(emp.getSal()!=null) {
				e.setSal(emp.getSal());
			}
			if(emp.getDeptno()!=null) {
				e.setDeptno(emp.getDeptno());
			}
		}
		return ejpa.save(e);
	}
	
	public void deleteById(int id) {
		ejpa.deleteById(id);
	}

}
