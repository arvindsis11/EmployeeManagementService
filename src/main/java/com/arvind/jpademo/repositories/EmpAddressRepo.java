package com.arvind.jpademo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arvind.jpademo.model.EmpAddress;
@Repository
public interface EmpAddressRepo extends JpaRepository<EmpAddress, Long>{
	
}
