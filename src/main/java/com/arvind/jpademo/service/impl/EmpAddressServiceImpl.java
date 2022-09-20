package com.arvind.jpademo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.arvind.jpademo.model.EmpAddress;
import com.arvind.jpademo.repositories.EmpAddressRepo;
import com.arvind.jpademo.service.EmpAddressService;

@Service
@Component
public class EmpAddressServiceImpl implements EmpAddressService {

	@Autowired
	private EmpAddressRepo empAddressRepo;

	@Override
	public List<EmpAddress> findAllEmpAddress() {

		return empAddressRepo.findAll();
	}

	@Override
	public ResponseEntity<EmpAddress> findEmpAddressById(Long id) {
		Optional<EmpAddress> college = empAddressRepo.findById(id);
		if (college.isPresent()) {
			return ResponseEntity.ok().body(college.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<EmpAddress> deleteEmpAddress(Long id) {
		Optional<EmpAddress> college = empAddressRepo.findById(id);
		if (college.isPresent()) {
			empAddressRepo.deleteById(id);
			return ResponseEntity.ok().body(college.get());
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public EmpAddress updateEmpAddress(Long id, EmpAddress newEmpAddress) {
		Optional<EmpAddress> empAddress = empAddressRepo.findById(id);
		return empAddress.map(data -> {
			data.setAdd_street(newEmpAddress.getAdd_street());
			return empAddressRepo.save(data);
		}).orElseGet(() -> {
			newEmpAddress.setAdd_id(id);
			return empAddressRepo.save(newEmpAddress);
		});

	}

	@Override
	public EmpAddress saveEmpAddress(EmpAddress empAddress) {
		return empAddressRepo.save(empAddress);
	}


}
