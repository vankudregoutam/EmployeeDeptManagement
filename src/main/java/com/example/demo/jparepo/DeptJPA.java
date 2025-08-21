package com.example.demo.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Dept;

public interface DeptJPA extends JpaRepository<Dept, Integer> {
	
	public boolean existsByName(String name);

}
