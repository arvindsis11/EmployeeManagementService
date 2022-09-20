package com.arvind.jpademo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
public class EmpAddress {

	@Id
	@Column(name = "`add_id`")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long add_id;
	private String add_street;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_add_id", referencedColumnName = "add_id")
	private List<Employee> employees;
	

}
