package com.ebit.smartgst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.smartgst.model.Dept;
import com.ebit.smartgst.repo.DeptRepository;

@RestController
@RequestMapping("dept")
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
	

	
}
