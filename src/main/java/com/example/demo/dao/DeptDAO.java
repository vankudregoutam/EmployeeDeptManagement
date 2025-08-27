package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Dept;
import com.example.demo.jparepo.DeptJPA;

@Repository
public class DeptDAO {
	
	@Autowired
	private DeptJPA djpa;
	
	public Dept saveDept(Dept d) {
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
