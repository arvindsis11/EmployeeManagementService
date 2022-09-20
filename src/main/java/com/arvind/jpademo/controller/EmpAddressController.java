package com.arvind.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.jpademo.model.EmpAddress;
import com.arvind.jpademo.service.EmpAddressService;

@RestController
@RequestMapping("/empAddress")
public class EmpAddressController {

	@Autowired
	private EmpAddressService empAddressService;

	
	@GetMapping
	public List<EmpAddress> getAllEmpAddress() {
		return empAddressService.findAllEmpAddress();
	}

	@PostMapping
	public EmpAddress createEmployee(@RequestBody EmpAddress empAddress) {

		return empAddressService.saveEmpAddress(empAddress);
	}

	// get college details by id;
	@GetMapping("/{id}")
	public ResponseEntity<EmpAddress> getEmpAddressById(@PathVariable(value = "id") long id) {
		return empAddressService.findEmpAddressById(id);

	}

	@PutMapping("/{id}")
	public EmpAddress updateEmpAddress(@PathVariable(value = "id") long id, @RequestBody EmpAddress newEmpAddress) {
		return empAddressService.updateEmpAddress(id, newEmpAddress);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<EmpAddress> deleteEmpAddress(@PathVariable(value = "id") Long id) {
		return empAddressService.deleteEmpAddress(id);
	}
}
