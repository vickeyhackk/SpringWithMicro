package com.PGS.Department.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PGS.Department.entity.Department;
import com.PGS.Department.repository.DepartmentRepository;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.save(department);
		
	}

	public Department findDepartmentById(Long departmentId) {
		log.info("Inside findDepartmentById of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}
}
