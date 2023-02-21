package com.PGS.Department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.PGS.Department.entity.Department;
import com.PGS.Department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		
		log.info("inside saveDepartment method of Departmentcontroller");
		return departmentService.saveDepartment(department);
	}
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId){
		log.info("inside saveDepartment method of DepartmentController");
		return departmentService.findDepartmentById(departmentId);
	}
}
