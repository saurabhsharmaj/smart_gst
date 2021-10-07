package com.ebit.smartgst.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.ebit.smartgst.model.Dept;
import com.ebit.smartgst.model.DeptDTO;
import com.ebit.smartgst.repo.DeptRepository;
import com.ebit.smartgst.utils.GstUtils;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("dept")
@SecurityRequirement(name = "smartgst")
public class DeptController {

	@Autowired
	DeptRepository deptRepo;

	@GetMapping("/get")
	public ResponseEntity<List<Dept>> getAll() {
		try {
			List<Dept> list = (List<Dept>) deptRepo.findAll();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/{id}")
	public Optional<Dept> getOne(@PathVariable long id) {
		return deptRepo.findById(id);

	}

	@PostMapping("/add")
	public String addEmplyee(@RequestBody Dept emp) {
		deptRepo.save(emp);
		return "saved Successfullly";

	}
	
	@PostMapping("/add/dept")
	public String addDept(@Valid @RequestBody DeptDTO deptDTO) {
		deptRepo.save(GstUtils.deptMapper(deptDTO));
		return "saved Successfullly";

	}

	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable long id, @RequestBody Dept emp) {
		deptRepo.save(emp);
		return "Updated Successfully";
	}

	@DeleteMapping("/delete/all")
	public String deleteAll() {
		deptRepo.deleteAll();
		return "All Records Deleted";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOne(@PathVariable long id) {
		deptRepo.deleteById(id);
		return "Record deleted";
	}
}
