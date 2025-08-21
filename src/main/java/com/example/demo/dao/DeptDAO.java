package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Dept;
import com.example.demo.entity.Employee;
import com.example.demo.jparepo.DeptJPA;
import com.example.demo.jparepo.EmpJPA;

@Repository
public class DeptDAO {
	
	@Autowired
	private DeptJPA djpa;
	
	@Autowired
	private EmpJPA ejpa;
	
	public Dept saveDept(int id, Dept d) {
		Optional<Employee> option = ejpa.findById(id);
		if(option.isPresent()) {
			Employee e = option.get();
			e.setDept(d);
		}
		return djpa.save(d);
	}
	
	public Dept findById(int id) {
		Optional<Dept> option = djpa.findById(id);
		return option.isPresent()?option.get():null;
	}
	
	public List<Dept> fetchAll() {
		return djpa.findAll();
	}
	
	public void deleteById(int id) {
		djpa.deleteById(id);
	}
	
	public Dept updateById(Dept dept) {
		return djpa.save(dept);
	}

}
