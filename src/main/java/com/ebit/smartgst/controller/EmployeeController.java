package com.ebit.smartgst.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.smartgst.model.Employee;
import com.ebit.smartgst.repo.EmployeeRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("emp")
@SecurityRequirement(name = "smartgst")
public class EmployeeController {

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAll() {
		try {
			List<Employee> list = (List<Employee>) empRepo.findAll();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{id}")
	public Optional<Employee> getOne(@PathVariable long id) {

		return empRepo.findById(id);

	}

	@PostMapping("/add")
	public String addEmplyee(@RequestBody Employee emp) {

		empRepo.save(emp);
		return "saved Successfullly";

	}

	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable long id, @RequestBody Employee emp) {

		empRepo.save(emp);
		return "Updated Successfully";
	}

	@DeleteMapping("/delete/all")
	public String deleteAll() {

		empRepo.deleteAll();
		return "All Records Deleted";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOne(@PathVariable long id) {
		empRepo.deleteById(id);
		return "Record deleted";
	}

}
