package com.arvind.jpademo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.arvind.jpademo.model.EmpAddress;

public interface EmpAddressService {
	public List<EmpAddress> findAllEmpAddress();

	public ResponseEntity<EmpAddress> findEmpAddressById(Long id);

	public EmpAddress saveEmpAddress(EmpAddress empAddress);

	public ResponseEntity<EmpAddress> deleteEmpAddress(Long id);

	public EmpAddress updateEmpAddress(Long id, EmpAddress newEmpAddress);
}
