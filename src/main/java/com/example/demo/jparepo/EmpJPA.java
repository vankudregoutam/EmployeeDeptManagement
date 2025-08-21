package com.example.demo.jparepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Employee;

public interface EmpJPA extends JpaRepository<Employee, Integer> {
	
	public List<Employee> findByDept_depno(int id);
	
//	@Query(value = "update employee set name=?1 and sal=?2 and com=?3 and deptno=?4 where id=:id", nativeQuery = true)
//	public Employee updateById(int id, Employee e);
	
//	public List<Employee> findByDept_dept(int id);

}
